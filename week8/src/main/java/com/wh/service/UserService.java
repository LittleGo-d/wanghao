package com.wh.service;

import com.wh.bean.User;
import com.wh.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author whstart
 * @creat 2022--21-15:51
 */
public interface UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    User login(String username, String password);

    User selectByName(String name);

    void update(User user);

}
