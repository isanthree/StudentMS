package com.sbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {

        try {
            // 加载 MySQL 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL 驱动加载成功");
            // 连接数据库，获得连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "h020809.");
            System.out.println("MySQL 数据库连接成功");
            // 创建 mysql 语句执行环境
            Statement statement = conn.createStatement();
            // 执行 mysql 语句，得到结果集
            ResultSet result = statement.executeQuery("SELECT * FROM info");
            // 循环取出结果集的每一项
            while(result.next()) {
                System.out.print(result.getInt("id") + " ");
                System.out.print(result.getString("uname") + " ");
                System.out.println(result.getString("upass"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MySQL 驱动加载失败");
            System.out.println("MySQL 数据库连接失败");
        }

    }
}
