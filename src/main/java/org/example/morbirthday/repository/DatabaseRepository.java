package org.example.morbirthday.repository;

import org.example.morbirthday.model.Dinner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DatabaseRepository {
    private JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public DatabaseRepository(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                System.getenv(dbUrl),
                System.getenv(username),
                System.getenv(password)
        );
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Dinner> findAll() {
        List<Dinner> dinners = new ArrayList<>();
        String sql = "SELECT * FROM gave";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Dinner dinner = new Dinner(resultSet.getString("name"), resultSet.getString("email"));
                dinners.add(dinner);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dinners;
    }

    public void addDinner(Dinner dinner){
        String name = dinner.getName();
        String email = dinner.getEmail();
        String sql ="INSERT INTO gave (name, email) VALUES (?, ?) ";
        jdbcTemplate.update(sql, name, email);
    }

}








