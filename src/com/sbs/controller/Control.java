package com.sbs.controller;

import com.sbs.bean.User;
import com.sbs.dao.UserDao_Imp;
import com.sbs.view.View;

public class Control {

    public static void main(String[] args) {
        // 给用户展示登陆页面
        while (true) {
            User user = View.indexView();
            UserDao_Imp userDao_Imp = new UserDao_Imp();
            int type = userDao_Imp.login(user);

            switch (type) {
                case -1:
                    System.out.println("账号或密码错误，请重新输入！");
                    break;
                case 1:
                    System.out.println("恭喜管理员登录成功！");
                    managerServer();
                    break;
                case 2:
                    System.out.println("恭喜学生登录成功！");
                    studentServer(user.getUname());
                    break;
                default:
                    break;
            }
        }
    }

    private static void managerServer() {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        int choice = 1;
        while (choice != 0) {
            // 展示管理员菜单视图
            choice = View.manageMenuView();
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    break;
                case 1:
                    User newUser = View.addMenuView();
                    if (userDao_Imp.insert(newUser)){
                        System.out.println("添加成功！");
                    }else {
                        System.out.println("添加失败！");
                    }
                    break;
                case 2:
                    String uname = View.deleteMenuView();
                    if (userDao_Imp.delete(uname)){
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("删除失败！");
                        //
                    }
                    break;
                case 3:
                    User user = View.updateMenuView();
                    if (userDao_Imp.update(user)){
                        System.out.println("修改成功！");
                    }else {
                        System.out.println("修改失败");
                        //
                    }
                    break;
                case 4:
                    String uname1 = View.selectMenuView();
                    User selectedUser = userDao_Imp.select(uname1);
                    printUser(selectedUser);
                    break;
                default:
                    break;
            }
        }
    }

    private static void studentServer(String uname) {
        UserDao_Imp userDao_Imp = new UserDao_Imp();
        boolean flag = true; // 循环标志位
        while (flag){
            int choice = View.studentMenuView(); // 选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    String password = View.alterPassView();
                    if (userDao_Imp.update(new User(uname, password))) {
                        System.out.println("恭喜修改密码成功！");
                    } else {
                        System.out.println("修改密码失败！");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void printUser(User user) {
        if (user == null) {
            System.out.println("查无此人");
            return;
        }
        System.out.println("用户 id：" + user.getId());
        System.out.println("用户名：" + user.getUname());
        System.out.println("用户密码：" + user.getUpass());
        if (user.getType() == 1) {
            System.out.println("用户权限：管理员");
        } else {
            System.out.println("用户权限：普通用户");
        }
    }
}
