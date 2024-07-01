package group40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class H2MemoryDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseManager manager = new DatabaseManager();
        manager.getConnection();
        manager.createTable();
        manager.getEmployee();
        manager.close();
    }
}
