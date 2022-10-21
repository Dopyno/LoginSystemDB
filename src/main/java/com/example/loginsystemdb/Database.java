package com.example.loginsystemdb;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Database{
    public static final String DB_NAME = "localDB.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Java project\\LoginSystemDB\\src\\main\\java\\" + DB_NAME;
    public static final String TABLE_NAME = "persons";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String SPACE = " ";
    public static final String COMMA = "\", \"";

    public static Connection getConnection() {
            try {
               return  DriverManager.getConnection(CONNECTION_STRING);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
//    public static void getPerson(Statement statement, String user, String pass,String na, String ads, String em, String ph) throws SQLException{
//            statement.execute("INSERT INTO " + TABLE_NAME + " (username, password, name, address, email, phone) VALUES ("
//                    + user + COMMA + pass + COMMA + na + COMMA + ads + COMMA + em + COMMA + ph);
//            System.out.println("Person added successfully to database!");
//            statement.close();
//    }
//    public static boolean fiindPerson(String user){
//       boolean rez;
//        try {
//            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT count(username) FROM " +  TABLE_NAME + " WHERE username=\"" + user + "\");");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(COLUMN_ID) + SPACE + resultSet.getString(COLUMN_USERNAME) + SPACE + resultSet.getString(COLUMN_NAME) +
//                        resultSet.getString(COLUMN_ADDRESS) + SPACE + resultSet.getString(COLUMN_EMAIL) + SPACE + resultSet.getString(COLUMN_PHONE));
//            }
//            resultSet.close();
//            statement.close();
//            conn.close();
//        }catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Something is wrong, please try again!");
//        }
//       return rez = true;
//    }
}

