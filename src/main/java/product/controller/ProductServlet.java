package product.controller;

import customer.model.Customer;
import product.model.Product;
import product.service.IProductDAO;
import product.service.ProductDAOmpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductDAO productDAO=new ProductDAOmpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "delete":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "sort-by-quantity":
                showSortByQuantity(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "edit":
//                showEditCustomer(request, response);
//                break;
//            case "delete":
//                try {
//                    deleteCustomer(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "sort-by-quantity":
//                showSortByQuantity(request,response);
//                break;
            default:
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        productDAO.add(new Product(id,name, price,quantity));
        response.sendRedirect("/customers");
    }
}
