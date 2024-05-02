package ru.sgu;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                              .directory("postgres-docker")
                              .load();
        String url = "jdbc:postgresql://localhost:5432/" + dotenv.get("POSTGRES_DB");
        String user = dotenv.get("POSTGRES_USER");
        String password = dotenv.get("POSTGRES_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Подключение с PostgreSQL сервером установлено. ");
            
            System.out.println("Запрос 1 : возраст > 20 " );
            String query1 = "SELECT * FROM employeesAge WHERE age > 20";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query1)) {
                while (rs.next()) {
                    System.out.println(rs.getString("employeeName") + " - " + rs.getInt("age"));
                }
            }
            
            System.out.println("Запрос 2 : Средняя зарплата по каждому отделу ");
            String query2 = "SELECT departmentName, AVG(salary) as averageSalary FROM departmentSalary GROUP BY departmentName";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query2)) {
                while (rs.next()) {
                    System.out.println(rs.getString("departmentName") + " - " + rs.getInt("averageSalary"));
                }
            }
            
            System.out.println("Запрос 3 : Имя сотрудника, его департамент и локацию " );
            String query3 = "SELECT de.employeeName, dl.departmentName, dl.location FROM departmentEmployee de JOIN departmentLocation dl ON de.departmentId = dl.departmentId";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query3)) {
                while (rs.next()) {
                    System.out.println(rs.getString("employeeName") + " - " + rs.getString("departmentName") + " - " + rs.getString("location"));
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
