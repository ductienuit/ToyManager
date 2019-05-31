/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author CMQ
 */
public class HibernateUtil {
    private static SessionFactory SESSION_FACTORY;

    public static SessionFactory getSESSION_FACTORY() {
        if (SESSION_FACTORY == null) {
            try {
                // configuration settings from hibernate.cfg.xml
                Configuration configuration = new Configuration().configure();
                StandardServiceRegistryBuilder serviceRegistryBuilder
                        = new StandardServiceRegistryBuilder();
                serviceRegistryBuilder
                        .applySettings(configuration.getProperties());

                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

                SESSION_FACTORY = (SessionFactory) configuration
                        .buildSessionFactory(
                                serviceRegistry);
            } catch (HibernateException ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed."
                        + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return SESSION_FACTORY;
    }

    public static void beginTransaction(ISession action) {
        if (action == null) {
            return;
        }
        //DT: getSession is null
        Session session = getSESSION_FACTORY()
                .openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            action.onTransactionBegan(session,
                    transaction);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
