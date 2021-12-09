package demo_8_12.service;

import demo_8_12.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService extends General<Category>{
    @Override
    void add(Category customer) throws SQLException;

    @Override
    List<Category> findAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Category category) throws SQLException;
}
