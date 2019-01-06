package petrossov.dao;

import petrossov.Models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoJdbcImpl implements ProductDao {

    //language=SQL
    private final String SQL_SELECT_ALL =
            "SELECT * FROM product_db";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM product_db WHERE ID = ?";
    //language=SQL
    private final String SQL_DELETE =
            "DELETE  FROM product_db WHERE ID  = ?";

    //language=SQL
    private final String SQL_SAVE =
            "INSERT INTO product_db(name, laminat, mdf, tabletop" +
                    ",arm, leg, extensionsystem, loop," +
                    "sink, fastener, additional, productprice) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    //language=SQL
    private final String SQL_SAVE_BY_ID =
            "INSERT INTO product_db(id,name, laminat, mdf, tabletop" +
                    ",arm, leg, extensionsystem, loop," +
                    "sink, fastener, additional, productprice) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";


    private Connection connection;

    public ProductDaoJdbcImpl(DataSource dataSource){
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }



    @Override
    public Optional<Product> find(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet =statement.executeQuery();
            if (resultSet.next()){

                String name = resultSet.getString("name");
                Integer laminat = resultSet.getInt("laminat");
                Integer mdf = resultSet.getInt("mdf");
                Integer tableTop = resultSet.getInt("tabletop");
                Integer arm = resultSet.getInt("arm");
                Integer leg = resultSet.getInt("leg");
                Integer extensionSystem = resultSet.getInt("extensionsystem");
                Integer loop = resultSet.getInt("loop");
                Integer sink = resultSet.getInt("sink");
                Integer fastener = resultSet.getInt("fastener");
                Integer additional = resultSet.getInt("additional");
                Integer productPrice = resultSet.getInt("productprice");

                return Optional.of(new Product(id, name, laminat, mdf, tableTop
                                                ,arm, leg, extensionSystem, loop
                                                ,sink, fastener, additional, productPrice));
            }
            return  Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }



    @Override
    public void save(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE);


            String name = product.getName();
            Integer laminat = product.getLaminat();
            Integer mdf = product.getMdf();
            Integer tableTop = product.getTableTop();
            Integer arm = product.getArm();
            Integer leg = product.getLeg();
            Integer extensionSystem = product.getExtensionSystem();
            Integer loop = product.getLoop();
            Integer sink = product.getSink();
            Integer fastener = product.getFastener();
            Integer additional = product.getAdditional();
            Integer productPrice = product.getProductPrice();


            statement.setString(1,name);
           statement.setInt(2,laminat);
           statement.setInt(3,mdf);
           statement.setInt(4,tableTop);
           statement.setInt(5,arm);
           statement.setInt(6,leg);
           statement.setInt(7,extensionSystem);
           statement.setInt(8,loop);
           statement.setInt(9,sink);
           statement.setInt(10,fastener);
           statement.setInt(11,additional);
           statement.setInt(12,productPrice);
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

 /*   @Override
    public void update(Product product) {

    }*/

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

 /*   @Override
    public void delete(String id) {

    }*/

    @Override
    public List<Product> findAll() {
        try {
            List<Product> products = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer laminat = resultSet.getInt("laminat");
                Integer mdf = resultSet.getInt("mdf");
                Integer tableTop = resultSet.getInt("tabletop");
                Integer arm = resultSet.getInt("arm");
                Integer leg = resultSet.getInt("leg");
                Integer extensionSystem = resultSet.getInt("extensionsystem");
                Integer loop = resultSet.getInt("loop");
                Integer sink = resultSet.getInt("sink");
                Integer fastener = resultSet.getInt("fastener");
                Integer additional = resultSet.getInt("additional");
                Integer productPrice = resultSet.getInt("productprice");

                Product product = new Product(id,name, laminat, mdf, tableTop
                        ,arm, leg, extensionSystem, loop
                        ,sink, fastener, additional, productPrice);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void saveById(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_BY_ID);

            Integer id = product.getId();
            String name = product.getName();
            Integer laminat = product.getLaminat();
            Integer mdf = product.getMdf();
            Integer tableTop = product.getTableTop();
            Integer arm = product.getArm();
            Integer leg = product.getLeg();
            Integer extensionSystem = product.getExtensionSystem();
            Integer loop = product.getLoop();
            Integer sink = product.getSink();
            Integer fastener = product.getFastener();
            Integer additional = product.getAdditional();
            Integer productPrice = product.getProductPrice();


            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,laminat);
            statement.setInt(4,mdf);
            statement.setInt(5,tableTop);
            statement.setInt(6,arm);
            statement.setInt(7,leg);
            statement.setInt(8,extensionSystem);
            statement.setInt(9,loop);
            statement.setInt(10,sink);
            statement.setInt(11,fastener);
            statement.setInt(12,additional);
            statement.setInt(13,productPrice);
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
