package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.impl.ProductDao;
import ra.model.Product;
import ra.service.IGenericService;

import java.util.List;

@Service
public class ProductService implements IGenericService<Product,Integer> {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }
}
