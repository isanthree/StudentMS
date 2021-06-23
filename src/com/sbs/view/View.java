package com.sbs.view;

import com.sbs.bean.User;

import java.util.Scanner;

public class View {
    // 获取用户输入的信息
    private static Scanner input = new Scanner(System.in);

    // 首页视图
    public static User indexView() {
        System.out.println("************************************************************");
        System.out.println("****************\t\t学生信息管理系统\t\t****************");
        System.out.println("****************\t\t请根据提示操作\t\t****************");
        System.out.println("****************\t\t请输入账号\t\t********************");
        String uname = input.nextLine();
        System.out.println("****************\t\t请输入密码\t\t********************");
        String upass = input.nextLine();

        return new User(uname, upass);
    }

    // 管理员菜单视图
    public static int manageMenuView() {
        System.out.println("************************************************************");
        System.out.println("****************\t\t欢迎管理员回家\t\t****************");
        System.out.println("****************\t\t请根据提示操作\t\t****************");
        System.out.println("****************\t\t0. 退出\t\t********************");
        System.out.println("****************\t\t1. 添加学生信息\t\t********************");
        System.out.println("****************\t\t2. 删除学生信息\t\t********************");
        System.out.println("****************\t\t3. 修改学生信息\t\t********************");
        System.out.println("****************\t\t4. 查询学生信息\t\t********************");
        // 获取用户输入的信息
        String type = input.nextLine();
        // string 转换成 int
        int item = Integer.parseInt(type);
        if (item < 0 || item > 4) {
            System.out.println("输入错误，请重新输入！");
            return manageMenuView();
        }

        System.out.println("************************************************************");

        return item;
    }

}
