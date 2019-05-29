/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.common.BasicDAO;
import dto.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 *
 * @author CMQ
 */
public class UserDAO extends BasicDAO<User> {
    public UserDAO() {
        super(User.class);
    }

    public User getUser(final String username,
                        final String password) {
        final ObjectWrapper<User> userWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(User.class)
                .add(Restrictions.eq("username",
                                     username))
                .add(Restrictions.eq("password",
                                     password));

            List result = criteria.list();
            if (!result.isEmpty()) {
                userWrapper.setObject((User) result.get(0));
            }
        });

        return userWrapper.getObject();
    }

    public boolean hasUser(final String username) {
        final ObjectWrapper<Boolean> resultWrapper = new ObjectWrapper<>(false);

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(User.class)
                .add(Restrictions.eq("username",
                                     username));

            List result = criteria.list();
            if (!result.isEmpty()) {
                resultWrapper.setObject(true);
            }
        });

        return resultWrapper.getObject();
    }

    public List<User> getUsersByStatusId(final long statusId) {
        final ObjectWrapper<List<User>> usersWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(User.class)
                .createCriteria("userStatus")
                .add(Restrictions.eq("id",
                                     statusId));

            List result = criteria.list();
            usersWrapper.setObject(result);
        });

        return usersWrapper.getObject();
    }
}
