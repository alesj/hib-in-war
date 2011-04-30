package org.jboss.test.isolation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.io.Serializable;

/**
 * @author Emmanuel Bernard
 * @author Ales Justin
 */
@Stateless
@TransactionAttribute
@SessionScoped
public class UserManager implements Serializable {

   @PersistenceContext
	private transient EntityManager em;

   private synchronized EntityManager getEM()
   {
      if (em == null)
         em = Persistence.createEntityManagerFactory("pu").createEntityManager();

      return em;
   }

	public void saveUser(User user) {
		getEM().persist( user );
	}
}
