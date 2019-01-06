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
import java.util.List;
import java.util.Optional;
import java.util.Properties;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

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

        String id = request.getParameter("idUpdate");
        Integer idInt = Integer.parseInt(id);

        Optional<Product> productOptional = productDao.find(idInt);
        Product product = productOptional.get();
        request.setAttribute("productFromServer",product);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/update.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String laminat = request.getParameter("laminat");
        String mdf = request.getParameter("mdf");
        String tableTop = request.getParameter("tableTop");
        String arm = request.getParameter("arm");
        String leg = request.getParameter("leg");
        String extensionSystem = request.getParameter("extensionSystem");
        String loop = request.getParameter("loop");
        String sink = request.getParameter("sink");
        String fastener = request.getParameter("fastener");
        String additional = request.getParameter("additional");
        String productPrice = request.getParameter("productPrice");


        Integer idInt = Integer.parseInt(id);
        productDao.delete(idInt);
        Integer laminatQty = Integer.parseInt(laminat);
        Integer mdfQty = Integer.parseInt(mdf);
        Integer tableTopQty = Integer.parseInt(tableTop);
        Integer armQty = Integer.parseInt(arm);
        Integer legQty = Integer.parseInt(leg);
        Integer extensionSystemQty = Integer.parseInt(extensionSystem);
        Integer loopSystemQty = Integer.parseInt(loop);
        Integer sinkQty = Integer.parseInt(sink);
        Integer fastenerQty = Integer.parseInt(fastener);
        Integer additionalQty = Integer.parseInt(additional);
        Integer productPriceInt = Integer.parseInt(productPrice);

        Product product = new Product(idInt,name,laminatQty,mdfQty,tableTopQty,armQty,legQty
                ,extensionSystemQty,loopSystemQty,sinkQty,fastenerQty
                ,additionalQty,productPriceInt);

        productDao.saveById(product);

        response.sendRedirect("/table");




    }
}
