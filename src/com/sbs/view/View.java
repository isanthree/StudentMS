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

    // 添加学生信息视图
    // @return：新的 User 对象 User(uname, upass)
    public static User addMenuView() {
        System.out.println("************************************************************");
        System.out.println("****************\t\t请根据提示操作\t\t****************");
        System.out.println("****************\t\t请输入账号\t\t********************");
        String uname = input.nextLine();
        System.out.println("****************\t\t请输入密码\t\t********************");
        String upass = input.nextLine();
        System.out.println("************************************************************");

        return new User(uname, upass);
    }

    /**
     * 删除用户界面
     * @return 返回删除的学生账号
     */
    public static String deleteMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t删除用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入要删除的学生账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }

    /**
     * 更新修改用户界面
     * @return User(uname,upass)
     */
    public static User updateMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t修改用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /**
     * 查询用户界面
     * @return 返回查询的用户信息
     */
    public static String selectMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t查询用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入查询账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }

}
