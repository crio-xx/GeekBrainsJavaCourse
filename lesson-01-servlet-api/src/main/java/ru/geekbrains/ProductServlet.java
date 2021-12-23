package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            Product product = null;
            try {
                product = productRepository.findById(Long.parseLong(id));
            } catch (NumberFormatException ignored) {
            }
            if(product != null) {
                wr.println(String.format("<h1>ID = %d</h1>", product.getId()));
                wr.println(String.format("<h3>%s</h3>", product.getName()));
            } else {
                wr.println(String.format("<h1>Error. Not found the product with id =  %s</h1>", id));
            }

        } else if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            wr.println("<table>");

            wr.println("<tr>");
            wr.println("<th>Id</th>");
            wr.println("<th>Name</th>");
            wr.println("</tr>");

            for (Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td>" + product.getId() + "</td>");
                wr.println(String.format("<td><a href='product?id=%d'>%s</a></td>", product.getId(), product.getName()));
                wr.println("</tr>");
            }

            wr.println("</table>");
        }
    }
}
