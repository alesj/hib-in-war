package org.jboss.test.isolation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Emmanuel Bernard
 * @author Ales Justin
 */
// @Stateless @TransactionAttribute
public class UserManager {
	//@PersistenceContext
	EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();

	public void saveUser(User user) {
		em.persist( user );
	}
}
