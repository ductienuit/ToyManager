/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CMQ
 */
public class EntityManagerUtil {
    private static EntityManager ENTITY_MANAGER;

    public static EntityManager getENTITY_MANAGER() {
        if (ENTITY_MANAGER == null) {
            EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("name");

            ENTITY_MANAGER = factory.createEntityManager();
        }

        return ENTITY_MANAGER;
    }
}
