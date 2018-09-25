package cn.liuxingwei.spring.mvc.maven.service;

import cn.liuxingwei.spring.mvc.maven.data.UserDao;
import cn.liuxingwei.spring.mvc.maven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUser(long userId){
        User user = userDao.getUser(userId);
        System.out.println();
        return user;
    }
}
