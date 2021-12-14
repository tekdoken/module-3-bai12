package ktra;

import ktra.model.Category;
import ktra.model.Product;
import ktra.service.CategoryService;
import ktra.service.ProductService;
import ktra.service.implement.CategoryServiceImpl;
import ktra.service.implement.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class productController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    private String showProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException, SQLException {
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
        model.addAttribute("newproduct", products);
        model.addAttribute("category", categoryList);
        return "index";
    }

    @GetMapping("/editForm")
    private String editForm(Model model, @RequestParam int id) throws SQLException {
        Product product = productService.findById(id);
        product.setId(id);
        List<Product> products = new ArrayList<>();
        products.add(product);
        List<Category> categoryList = null;
        categoryList = finAllCategory(products);
        model.addAttribute("editProduct", product);
        model.addAttribute("category", categoryList);
        return "edit";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam int id) throws SQLException {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/createForm")
    private String createForm() {
        return "create";
    }

    List<Category> finAllCategory(List<Product> products) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryService.findById(products.get(i).getCategoryId());
            categoryList.add(category);
        }
        return categoryList;
    }

    @PostMapping("/edit")
    private String edit(@RequestParam String description, String color, String name, int categoryId, int quantity, int price, int id) throws SQLException {
        productService.update(new Product(id, name, price, quantity, color, description, categoryId));
        return "redirect:/";
    }

    @PostMapping("/create")
    private String create(@RequestParam String description, String color, String name, int categoryId, int quantity, int price) throws SQLException, IOException {
        productService.add(new Product(name, price, quantity, color, description, categoryId));
        return "redirect:/";
    }
}
