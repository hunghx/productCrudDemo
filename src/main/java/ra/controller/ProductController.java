package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Product;
import ra.service.impl.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    private final String uploadPath ="C:\\Users\\hung1\\OneDrive\\Desktop\\productCRUD\\src\\main\\webapp\\WEB-INF\\upload\\";

    @Autowired
    private ProductService productService;
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("list", productService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String add (){
        return "add";
    }
    @PostMapping("/add")
    public  String doAdd(@ModelAttribute Product product, @RequestParam("image")MultipartFile file){
        // xử lí upload file
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImageUrl(fileName);
        productService.save(product);
        return "redirect:/";
    }
}
