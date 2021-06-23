package com.sbs.test;

import static org.junit.Assert.*;

import com.sbs.bean.User;
import com.sbs.view.View;
import org.junit.Test;

public class ViewTest {
    // 测试登陆页面视图
    @Test
    public static User indexViewTest() throws Exception {
        User user = View.indexView();
        return user;
    }

    // 测试管理员菜单视图
    @Test
    public static int manageMenuTest() throws Exception {
        int item = View.manageMenuView();
        System.out.println(item);

        return item;
    }

    public static void main(String[] args) throws Exception {
//        User user = indexViewTest();
        int item = manageMenuTest();
//        System.out.println(user);
    }
}
