package petrossov.Servlets;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import petrossov.Models.Product;
import petrossov.dao.ProductDao;
import petrossov.dao.ProductDaoJdbcImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


@WebServlet("/table")
public class TableServlet extends HttpServlet {

    private ProductDao productDao;


    Connection connection;
    @Override
    public void init() throws ServletException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        try {

            properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties"));
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");


            dataSource.setUsername(dbUser);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            productDao = new ProductDaoJdbcImpl(dataSource);


        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = productDao.findAll();
        request.setAttribute("productsFromServer",products);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Integer idInt = Integer.parseInt(id);
        productDao.delete(idInt);
        List<Product> products = productDao.findAll();
        request.setAttribute("productsFromServer",products);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(request,response);


    }
}
