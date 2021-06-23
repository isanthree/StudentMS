package com.sbs.test;

import com.sbs.bean.User;
import com.sbs.dao.UserDao;
import com.sbs.dao.UserDao_Imp;
import com.sbs.jdbc.JDBCUtils;
import org.junit.Test;
import org.hamcrest.SelfDescribing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtilsTest {

    @Test
    public void jdbcConnectionTest() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM info");
        while(result.next()) {
            System.out.print(result.getInt("id") + " ");
            System.out.print(result.getString("uname") + " ");
            System.out.println(result.getString("upass"));
        }
    }

    // 测试登陆
    @Test
    public void loginTest() throws Exception {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        User user = new User("admin", "admin");
        int type = userDao_Imp.login(user);
        System.out.println("测试用户类型：" + type);
    }

    // 测试添加用户
    @Test
    public void insertTest() throws Exception {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        User user = new User("yangxi", "yx");
        boolean flag = userDao_Imp.insert(user);
        System.out.println("测试添加用户：" + flag);
    }

    // 测试删除用户
    @Test
    public void deleteTest() throws Exception {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        String uname = "yangxi";
        boolean flag = userDao_Imp.delete(uname);
        System.out.println("测试删除用户：" + flag);
    }

    // 测试更新用户密码
    @Test
    public void updateTest() throws Exception {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        User user = new User("a", "000");
        boolean flag = userDao_Imp.update(user);
        System.out.println("测试更新数据：" + flag);
    }

    // 测试查询用户
    @Test
    public void selectTest() throws Exception {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        String userName = "a";
        User user = userDao_Imp.select(userName);
        System.out.println("测试查询用户：" + user);
    }

}
