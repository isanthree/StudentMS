package com.sbs.dao;

import com.sbs.bean.User;

public interface UserDao {
    /**
     * 验证登陆的方法
     * @param user
     * @return int 类型 -1：登陆失败 1：管理员登陆 2：学生登陆
     */
    int login(User user);  // 抽象方法

    boolean insert(User user);

    boolean delete(String name);

    boolean update(String name);

    User select(String uname);

}
