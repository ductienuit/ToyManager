/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
                    .applySettings(configuration
                        .getProperties());

                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

                SESSION_FACTORY = configuration.buildSessionFactory(
                    serviceRegistry);
            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed."
                                       + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return SESSION_FACTORY;
    }

    public static void main(String[] args) {
        Session session = getSESSION_FACTORY()
            .openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Category c = new Category();
            c.setName("Category 1");
            session.save(c);
            tx.commit();

            System.out.println("Completed!");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error!");
        } finally {
            session.close();
        }

    }
}
