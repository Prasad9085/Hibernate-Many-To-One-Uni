package ManyToOne.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToOne.dao.companyDao;
import ManyToOne.dao.employeeDao;
import ManyToOne.dto.Company;
import ManyToOne.dto.Employee;
import net.bytebuddy.asm.Advice.Enter;

public class MainController {
	public static void main(String[] args) {
		employeeDao dao = new employeeDao();
		companyDao companyDao = new ManyToOne.dao.companyDao();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1.save employee \n2.delete employee \n3.update employee \n4.find employee by id \n5.find all employee \n6 add company \n 7 delete company \n 8.update company \n 9.find company \n 10 find all company \n 11.stop");
		int choice = scanner.nextInt();
		switch (choice) {

		case 1: {
			System.out.println("enter company id");
			int c_id = scanner.nextInt();

			Employee employee = new Employee();
			System.out.println("enter employye name ");
			String name = scanner.next();

			System.out.println("enter employee id");
			int id = scanner.nextInt();

			System.out.println("enter phone");
			long phone = scanner.nextLong();

			System.out.println("enter address");
			String address = scanner.next();

			employee.setId(id);
			employee.setName(name);
			employee.setAddress(address);
			employee.setPhone(phone);

			dao.saveEmployee(employee, c_id);

			break;
		}
		case 2: {
			System.out.println("enter employee id");
			int id = scanner.nextInt();
			dao.deleteEmployee(id);
			break;
		}
		case 3 :{
			Employee employee = new Employee();
			System.out.println("enter employye name ");
			String name = scanner.next();

			System.out.println("enter employee id");
			int id = scanner.nextInt();

			System.out.println("enter phone");
			long phone = scanner.nextLong();

			System.out.println("enter address");
			String address = scanner.next();

			employee.setName(name);
			employee.setAddress(address);
			employee.setPhone(phone);
			
			dao.updateEmployee(employee, id);
			break;
		}
		case 4 : {
			System.out.println("enter employee id");
			int id = scanner.nextInt();
			dao.findEmployee(id);
			break;
		}
		case 5 : {
			dao.findAll();
		}
		case 6 : {
			Company company =  new Company();
			System.out.println("enter id of company");
			int c_id =  scanner.nextInt();
			
			System.out.println("enter company name ");
			String name = scanner.next();

			
			System.out.println("enter company location ");
			String location = scanner.next();

			
			System.out.println("enter company gst ");
			String gst = scanner.next();
			
			company.setId(c_id);
			company.setName(name);
			company.setLocation(location);
			company.setGst(gst);
			
			companyDao.saveCompany(company);

			break;
		}
		case 7 : {
			System.out.println("enter company id");
			int c_id = scanner.nextInt();
			companyDao.deleteCompany(c_id);
			break;
		}
		case 8 : {
			Company company =  new Company();
			System.out.println("enter id of company");
			int c_id =  scanner.nextInt();
			
			System.out.println("enter  new company name ");
			String name = scanner.next();

			
			System.out.println("enter new company location ");
			String location = scanner.next();

			
			System.out.println("enter new company gst ");
			String gst = scanner.next();
			
			company.setName(name);
			company.setLocation(location);
			company.setGst(gst);
			companyDao.updateCompany(c_id,company);
		}
		}
	}
}
