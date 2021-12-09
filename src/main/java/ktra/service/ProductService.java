package ktra.service;


import ktra.model.Product;

import java.util.List;

public interface ProductService extends General<Product>{
    List<Product> findByName(String name);
}
