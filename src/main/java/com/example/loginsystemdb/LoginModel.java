package com.example.loginsystemdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;
    public LoginModel(){
        this.connection = Database.getConnection();
        if (connection == null) {
             System.exit(1);
        }
    }
    public boolean isDatabaseConnected(){
        return this.connection != null;
    }
    public boolean isLogin(String user, String password) throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM persons WHERE username= ? and password= ?";

        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, password);

            rs = pr.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            pr.close();
            rs.close();
        }
    }
    public void addUserToDB(String user, String password, String name, String address, String email, String phone)throws Exception{
        String sqlInsert = "INSERT INTO persons(username, password, name, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        createDb();
        try {
            connection = Database.getConnection();
            PreparedStatement pr = connection.prepareStatement(sqlInsert);
            pr.setString(1, user);
            pr.setString(2, password);
            pr.setString(3, name);
            pr.setString(4, address);
            pr.setString(5, email);
            pr.setString(6, phone);

            pr.execute();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createDb(){
        String sqlCreateDBTable = "CREATE TABLE IF NOT EXISTS persons(id INTEGER, username TEXT UNIQUE," +
                " password TEXT, name TEXT, address TEXT, email TEXT, phone TEXT, PRIMARY KEY(id AUTOINCREMENT))";
        try {
            connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlCreateDBTable);
            ps.execute();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
