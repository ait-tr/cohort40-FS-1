package group40;

import java.sql.*;

public class DatabaseManager {

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");
            org.h2.tools.Server.createWebServer("-web", "-webAllowOthers","-webPort","8082").start();
        }
        return connection;
    }

    public void createTable() throws SQLException {
        int result = 0;
        Statement statement = connection.createStatement();

        // создадим таблицу

        String sqlRequest = "CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(255))";

        System.out.println("Create table was success: " + statement.execute(sqlRequest));

        System.out.println();

        // добавим данные в нашу таблицу

        String sqlRequest1 = "INSERT INTO employees VALUES(1,'John')";
        String sqlRequest2 = "INSERT INTO employees VALUES(2,'Bill')";

        result = statement.executeUpdate(sqlRequest1);
        System.out.println("Insert first data was success: " + result);
        result = statement.executeUpdate(sqlRequest2);
        System.out.println("Insert first data was success: " + result);

        statement.close();

    }

    public void getEmployee() throws SQLException, ClassNotFoundException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id + ", name = " + name);
        }

        resultSet.close();
        statement.close();
    }

    public void close() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }

}
