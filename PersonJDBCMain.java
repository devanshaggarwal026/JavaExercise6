package com.robomq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.robomq.config.AppConfig;
import com.robomq.dao.PersonDao;
import com.robomq.pojo.Person;

public class PersonJDBCMain {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PersonDao personDAO = context.getBean(PersonDao.class);

		System.out.println("List of product is:");

		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}

		System.out.println("\nGet person with ID 2");

		Person personById = personDAO.getPersonById(101);
		System.out.println(personById);

		System.out.println("\nCreating product: ");
		Person person = new Person(102 , 100 , 2 , "oil" , "hair oil");
		System.out.println(person);
		personDAO.createPerson(person);
		System.out.println("\nList of product is:");

		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}

		System.out.println("\nDeleting product with ID 101");
		personDAO.deletePerson(personById);

		System.out.println("\nUpdate person with ID 102");

		Person pperson = personDAO.getPersonById(102);
		pperson.setName("CHANGED");
		personDAO.updatePerson(pperson);

		System.out.println("\nList of product is:");
		for (Person p : personDAO.getAllPersons()) {
			System.out.println(p);
		}

		context.close();
	}

}


