package ManyToOne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne.dto.Company;
import ManyToOne.dto.Employee;

public class companyDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveCompany(Company company) {
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void deleteCompany(int c_id)
	{
		Query query = entityManager.createQuery("select c.company.id from Employee c where c.company.id=?1");
		query.setParameter(1, c_id);
		List<Employee> employees=query.getResultList();
		if(employees.size()==0)
		{
			Company company =  entityManager.find(Company.class, c_id);
			if(company!=null)
			{
				entityTransaction.begin();
				entityManager.remove(company);
				entityTransaction.commit();
			}
		}
		else {
			System.out.println("there are employees in your company man how can u deletre company gadheeee");
		}
	}

	public void updateCompany(int c_id, Company company) {
		
		Company company1=entityManager.find(Company.class, c_id);
		if(company1!=null) {
			company.setId(company1.getId());
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
		}
	}
}
