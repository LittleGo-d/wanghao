package com.wh.service.impl;

import com.wh.bean.User;
import com.wh.mapper.UserMapper;
import com.wh.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author whstart
 * @creat 2022--21-15:53
 */
public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.login(username, password);

        if(user != null && user.toString().length() > 0){
            sqlSession.close();
        }
        return user;
    }

    @Override
    public User selectByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByName(name);
        sqlSession.close();

        return user;
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
