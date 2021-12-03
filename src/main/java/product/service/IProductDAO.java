package product.service;

import product.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IProductDAO {
    public void add(Product product)throws SQLException;
    public List<Product> findByName(String name);
    public List<Product> findAll();
    public List<Product> sortByQuantity();
    public Product findById(int id);
    public void delete(int id)throws SQLException;
    public boolean update(Product product)throws SQLException;
}
