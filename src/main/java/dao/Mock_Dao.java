package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.exception.ConstraintViolationException;

import dto.Mock_Table;

public class Mock_Dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(Mock_Table table) {	
			entityTransaction.begin();
			entityManager.persist(table);
			entityTransaction.commit();
	}

	public Mock_Table search_id(int id) {
		List<Mock_Table> lst = entityManager.createQuery("Select x from Mock_Table x where id=?1").setParameter(1, id)
				.getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}

	}

	public Mock_Table search_name(String name) {
		List<Mock_Table> lst = entityManager.createQuery("Select x from Mock_Table x where name=?1")
				.setParameter(1, name).getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}
	}

	public List<Mock_Table> fetchAll() {
		List<Mock_Table> lstall = entityManager.createQuery("Select x from Mock_Table x", Mock_Table.class)
				.getResultList();
		return lstall;
	}
}