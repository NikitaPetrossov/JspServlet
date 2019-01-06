package petrossov.RunTest;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUser ="postgres";
        String dbPassword = "nikitaola68791";
        String connectionUrl = "jdbc:postgresql://localhost:5432/jspServlet";

        Connection connection = DriverManager.getConnection(connectionUrl,dbUser,dbPassword);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery( "select  * from  product_db");

        while (resultSet.next()){
            System.out.println();

            System.out.print(resultSet.getString("name") + " ");


            System.out.println();
        }


    }

}
