package com.sbs.view;

import com.sbs.bean.User;

import java.util.Scanner;

public class View {
    // 获取用户输入的信息
    private static Scanner input = new Scanner(System.in);

    // 首页视图
    public static User indexView() {
        System.out.println("*********************************************************************");
        System.out.println("****************\t\t学生信息管理系统\t\t****************");
        System.out.println("****************\t\t请根据提示操作\t\t****************");
        System.out.println("****************\t\t请输入账号\t\t****************");
        String uname = input.nextLine();
        System.out.println("****************\t\t请输入密码\t\t****************");
        String upass = input.nextLine();

        return new User(uname, upass);
    }
}
