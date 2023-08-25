package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Product;
import ra.service.impl.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class ProductController {
    private final String uploadPath ="C:\\Users\\hung1\\OneDrive\\Desktop\\productCRUD\\src\\main\\webapp\\WEB-INF\\upload\\";

    @Autowired
    private ProductService productService; //  dependence injection
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("list", productService.findAll());
        return "list";
    }
    @GetMapping("/add") // để chuyển hướng trang
    public String add (){
        return "add";
    }
    @PostMapping("/add") // tạo mới product
    public  String doAdd(@ModelAttribute Product product, @RequestParam("image")MultipartFile file){
        // xử lí upload file
        String fileName = file.getOriginalFilename();
        try {
            // uplaoad ảnh đến thư mục chỉ định
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImageUrl(fileName);
        productService.save(product);
        return "redirect:/";

    }
    // lấy thông tin của sp cần sửa và đổ ra view edit
    @GetMapping("/edit/{id}")
    public String  finById(@PathVariable("id") int  id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("productEdit",product);
        return  "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        // thực hiện  xóa
        productService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/update")
    public  String doUpdate(@ModelAttribute Product  proUpdate,@RequestParam("image") MultipartFile file){
       // xử lí uploaad file nếu cố
        if(file.isEmpty()){
            // ko có file đc upload lên , thì vẫn lấy giá trị cũ của ảnh
            proUpdate.setImageUrl(productService.findById(proUpdate.getCode()).getImageUrl());
        }else {
            // tiến hành upload và ghi đè link mới vào csdl
            // xử lí upload file
            String fileName = file.getOriginalFilename();
            try {
                // uplaoad ảnh đến thư mục chỉ định
                FileCopyUtils.copy(file.getBytes(),new File(uploadPath+fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            proUpdate.setImageUrl(fileName);
        }

        productService.save(proUpdate);
        return "redirect:/";
    }
}
