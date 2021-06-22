package com.sbs.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态语句块
    static {
        // 通过流（stream）形式去读取 .properties 文件资源
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");  // is: input stream
        // 创建 Properties 类型的对象，操控 .properties 流文件
        Properties p = new Properties();
        // 加载流文件
        try {
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            // 加载 MySQL 驱动
            Class.forName(driver);
            System.out.println("MySQL 驱动加载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获得连接对象的方法
    public static Connection getConnection() {
        try {
            // 连接数据库，获得连接对象
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("MySQL 数据库连接成功");
            return conn;
        } catch (SQLException e) {
            System.out.println("MySQL 数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    // 释放资源的方法
    public static void close(Connection conn, Statement statement, ResultSet result) {
        try {
            if (result != null) {
                result.close();
                result = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        getConnection();
//    }
}
