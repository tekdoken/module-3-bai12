package ktra.service;

import java.sql.SQLException;
import java.util.List;

public interface General<T> {
    public void add(T customer)throws SQLException;
    public T findById(int id)throws SQLException;
    public List<T> findAll();
    public boolean delete(int id)throws SQLException;
    public boolean update(T t)throws SQLException;
}
