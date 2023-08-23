package ra.dao.impl;

import org.springframework.stereotype.Repository;
import ra.dao.IGenericDao;
import ra.model.Product;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao implements IGenericDao<Product,Integer> {
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection conn =null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call findAllProducts()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Product pro = new Product();
                pro.setCode(rs.getInt("code"));
                pro.setProductName(rs.getString("product_name"));
                pro.setImageUrl(rs.getString("image_url"));
                pro.setProductPrice(rs.getDouble("price"));
                pro.setStock(rs.getInt("stock"));
                list.add(pro);

            }
        }catch (SQLException e){
            throw   new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Product pro = null;
        Connection conn =null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call findProductById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                pro = new Product();
                pro.setCode(rs.getInt("code"));
                pro.setProductName(rs.getString("product_name"));
                pro.setImageUrl(rs.getString("image_url"));
                pro.setProductPrice(rs.getDouble("price"));
                pro.setStock(rs.getInt("stock"));

            }
        }catch (SQLException e){
            throw   new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return pro;
    }

    @Override
    public void save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.getConnection();
            if(product.getCode()==0){
//            thêm mới
                callSt = conn.prepareCall("{call insertProducts(?,?,?,?)}");
                callSt.setString(1,product.getProductName());
                callSt.setString(2,product.getImageUrl());
                callSt.setDouble(3,product.getProductPrice());
                callSt.setInt(4,product.getStock());
                callSt.executeUpdate();
            }else {
//            cập nhật
                callSt = conn.prepareCall("{call updateProducts(?,?,?,?,?)}");
                callSt.setString(2,product.getProductName());
                callSt.setString(3,product.getImageUrl());
                callSt.setDouble(4,product.getProductPrice());
                callSt.setInt(5,product.getStock());
                callSt.setInt(1,product.getCode());
                callSt.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }


    }

    @Override
    public void delete(Integer id) {
        Connection conn =null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call deleteProductById(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();

        }catch (SQLException e){
            throw   new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
