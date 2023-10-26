package ManyToOne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne.dto.Company;
import ManyToOne.dto.Employee;

public class employeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mayur");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//	public void saveEmployee(Employee employee) {
//		
//		Company company =  employee.getCompany();
//		entityTransaction.begin();
//		entityManager.persist(company);
//		entityManager.persist(employee);
//		
//		entityTransaction.commit();
//	}
	
	public void saveEmployee(Employee employee , int c_id) {
		
		Company company =entityManager.find(Company.class,c_id);
		if(company!=null)
		{
			employee.setCompany(company);
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
		}else {
			System.out.println("gadhaaa first add company with id == "+ c_id);
		}
		
		
	}
	
	public void deleteEmployee(int id) {
		Employee  employee =entityManager.find(Employee.class,id);
		if(employee!=null)
		{
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
		
	}
	
	public void findEmployee(int id)
	{
		Employee  employee =entityManager.find(Employee.class,id);
		if(employee!=null)
		{
			System.out.println(employee);
		}
	}
	
	public void updateEmployee(Employee employee , int id )
	{
		Employee employee2 = entityManager.find(Employee.class, id);
		if(employee2!=null)
		{
			employee.setId(employee2.getId());
			employee.setCompany(employee2.getCompany());
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		
	}
	
	public void findAll()
	{
		Query query =  entityManager.createQuery("select e from Employee e");
		List<Employee> employees =query.getResultList();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
