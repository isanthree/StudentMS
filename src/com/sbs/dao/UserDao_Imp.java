package com.sbs.dao;

import com.sbs.bean.User;
import com.sbs.jdbc.JDBCUtils;

import java.sql.*;

// UserDao 的实现类
public class UserDao_Imp implements UserDao {
    private static final String SQL_USER_LOGIN = "select type from user where uname = ? and upass = ?";
    private static final String SQL_USER_INSERT = "insert into user(uname, upass, type) values (?, ?, 2)";
    private static final String SQL_USER_DELETE = "delete from user where uname=?";
    private static final String SQL_USER_UPDATE = "update user set upass=? where uname=?";
    private static final String SQL_USER_SELECT = "select * from user where uname=?";

    @Override
    public int login(User user) {
        // 连接数据库，创建连接对象 conn
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        // 创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_LOGIN);
        // 设置 sql 语句中的参数
            preparedStatement.setString(1, user.getUname());  // 第一个问号的值
            preparedStatement.setString(2, user.getUpass());  // 第二个问号的值
        // 执行语句
            result = preparedStatement.executeQuery();

            while (result.next()) {
                int type = result.getInt("type");
                return type;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, result);
        }

        return -1;
    }

    @Override
    public boolean insert(User user) {
        // 连接数据库，创建连接对象 conn
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            // 创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_INSERT);
            // 设置 sql 语句中的参数
            preparedStatement.setString(1, user.getUname());  // 第一个问号的值
            preparedStatement.setString(2, user.getUpass());  // 第二个问号的值
            // 执行语句
            int line = preparedStatement.executeUpdate();

            return line > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean delete(String uname) {
        // 连接数据库，创建连接对象 conn
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            // 创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_DELETE);
            // 设置 sql 语句中的参数
            preparedStatement.setString(1, uname);  // 第一个问号的值

            // 执行语句
            int line = preparedStatement.executeUpdate();

            return line > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
        return false;
    }

    // 这里实现的是更新密码
    @Override
    public boolean update(User user) {
        // 连接数据库，创建连接对象 conn
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            // 创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_UPDATE);
            // 设置 sql 语句中的参数
            preparedStatement.setString(1, user.getUpass());
            preparedStatement.setString(2, user.getUname());

            // 执行语句
            int line = preparedStatement.executeUpdate();

            return line > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
        return false;
    }

    @Override
    public User select(String uname) {
        // 连接数据库，创建连接对象 conn
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            // 创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_SELECT);
            // 设置 sql 语句中的参数
            preparedStatement.setString(1, uname);  // 第一个问号的值
            // 执行语句
            result = preparedStatement.executeQuery();

            if (result.next()) {
//                uname = result.getString("uname");
                String upass = result.getString("upass");
                int type = result.getInt("type");
                return new User(uname, upass, type);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, result);
        }

        return null;
    }
}
