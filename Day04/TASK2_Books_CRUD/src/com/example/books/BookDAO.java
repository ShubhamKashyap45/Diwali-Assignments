package com.example.books;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/day04_books";
    private static final String USER = "root";
    private static final String PASS = "password";

    public List<Book> list() throws Exception {
        List<Book> out = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection c = DriverManager.getConnection(URL, USER, PASS);
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                Book b = new Book();
                b.id = rs.getInt("id"); b.title = rs.getString("title"); b.author = rs.getString("author"); b.price = rs.getDouble("price");
                out.add(b);
            }
        }
        return out;
    }
    // Insert, update, delete methods left as exercise (scaffolded)
}
