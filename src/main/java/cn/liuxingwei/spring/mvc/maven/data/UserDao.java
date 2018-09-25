package cn.liuxingwei.spring.mvc.maven.data;

import cn.liuxingwei.spring.mvc.maven.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao{

    public void addUser(User user) {
        getHibernateTemplate().save(user);
    }

    public void updateUser(User user) {
        getHibernateTemplate().update(user);
    }

    public User getUser(long userId) {
        return getHibernateTemplate().get(User.class, userId);
    }

    public List<User> findUserByUserName(String userName) {
        return (List<User>) getHibernateTemplate().find(
                "from t_user where t_user.user_name like ?", userName + "%"
        );
    }

    public long getUserNum() {
        Object obj = getHibernateTemplate()
                .iterate("select count(t_user.user_id) from t_user")
                .next();
        return (Long) obj;
    }
}
