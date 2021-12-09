package demo_8_12.service;

import demo_8_12.model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface BlogService extends General<Blog>{
    @Override
    void add(Blog customer) throws SQLException;

    @Override
    List<Blog> findAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Blog blog) throws SQLException;
}
