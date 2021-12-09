package ktra.controller;


import ktra.model.Category;
import ktra.model.Product;
import ktra.service.CategoryService;
import ktra.service.ProductService;
import ktra.service.implement.CategoryServiceImpl;
import ktra.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewProductServlet", value = "")
public class NewProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = (CategoryService) new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                try {
                    editForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showProduct(request, response);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ktra/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Product> products = new ArrayList<>();
        products.add(product);
        List<Category> categoryList = null;
        try {
            categoryList = finAllCategory(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("editProduct", product);
        request.setAttribute("category", categoryList);
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/");
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ktra/create.jsp");
        List<Product> products = productService.findAll();
        List<Category> categoryList = null;
        try {
            categoryList = finAllCategory(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("category", categoryList);
        requestDispatcher.forward(request, response);
    }

    List<Category> finAllCategory(List<Product> products) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryService.findById(products.get(i).getCategoryId());
            categoryList.add(category);
        }
        return categoryList;
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ktra/show.jsp");
        List<Product> products;
        String name = request.getParameter("name");
        if (name == null) {
            products = productService.findAll();
        } else {
            products = productService.findByName(name);
        }
        List<Category> categoryList = null;
        try {
            categoryList = finAllCategory(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("newproduct", products);
        request.setAttribute("category", categoryList);
        requestDispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    edit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        productService.update(new Product(id, name, price, quantity, color, description, categoryId));
        response.sendRedirect("/");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String color = request.getParameter("color");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        productService.add(new Product(name, price, quantity, color, description, categoryId));
        response.sendRedirect("/");
    }
}
