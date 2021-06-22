package com.sbs.test;

import static org.junit.Assert.*;

import com.sbs.bean.User;
import com.sbs.view.View;
import org.junit.Test;

public class ViewTest {
    @Test
    public static User indexViewTest() throws Exception {
        User user = View.indexView();
        return user;
    }

    public static void main(String[] args) throws Exception {
        User user = indexViewTest();
        System.out.println(user);
    }
}
