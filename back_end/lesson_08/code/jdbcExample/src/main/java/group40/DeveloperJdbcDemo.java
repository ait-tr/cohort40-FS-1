package group40;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperJdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Developer> database = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        System.out.println("Registration driver ...");
        Class.forName("org.h2.Driver");

        System.out.println("Creating database connection ...");
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa","");
        org.h2.tools.Server.createWebServer("-web", "-webAllowOthers","-webPort","8082").start();


        System.out.println("Execute statement ...");
        statement = connection.createStatement();

        // создать таблицу

        String sqlRequest = "CREATE TABLE developers (id INT PRIMARY KEY, name VARCHAR(255), specialty VARCHAR(255), salary INT)";

        statement.execute(sqlRequest);

        // вставляем данные в таблицу

        String sqlRequest1 = "INSERT INTO developers VALUES(1,'John','back-end developer',5000)";
        String sqlRequest2 = "INSERT INTO developers VALUES(2,'Bill','front-end developer',4500)";
        String sqlRequest3 = "INSERT INTO developers VALUES(3,'Robert','DevOps',5500)";
        String sqlRequest4 = "INSERT INTO developers VALUES(4,'Olga','accounting',2500)";
        String sqlRequest5 = "INSERT INTO developers VALUES(5,'Ruslan','Team Lead',7000)";

        statement.execute(sqlRequest1);
        statement.execute(sqlRequest2);
        statement.execute(sqlRequest3);
        statement.execute(sqlRequest4);
        statement.execute(sqlRequest5);

        System.out.println("Receive data from database ...");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");

        while (resultSet.next()){
            System.out.println("==========");
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            Developer developer = new Developer(id,name,specialty,salary);

            System.out.println(developer);

            database.add(developer);
        }

        System.out.println("Working collection:");

        for (Developer developer : database){
            System.out.println(developer);
        }


        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

    }
}
