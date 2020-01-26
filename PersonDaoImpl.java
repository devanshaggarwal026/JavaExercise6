package com.robomq.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.robomq.pojo.Person;
import com.robomq.pojo.PersonMapper;

@Component
public class PersonDaoImpl implements PersonDao {
	
	JdbcTemplate jdbcTemplate;
	
	
	private final String SQL_FIND_PERSON = "select * from mobile where id = ?";
	private final String SQL_DELETE_PERSON = "delete from mobile where id = ?";
	private final String SQL_UPDATE_PERSON = "update mobile set name = ?, price  = ?, qty = ? , description  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from mobile";
	private final String SQL_INSERT_PERSON = "insert into mobile(id, name, price, qty ,description ) values(?,?,?,?,?)";
	
	
	
	@Autowired
	public PersonDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public Person getPersonById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id } ,new PersonMapper());
	}

	public List<Person> getAllPersons() {
		return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
	}

	public boolean deletePerson(Person person) {
		return jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0;
	}

	public boolean updatePerson(Person person) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getName(), 
				person.getPrice() , person.getQty() , person.getDescription() , person.getId()) > 0;
	}

	public boolean createPerson(Person person) {
		return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getName(), 
				person.getPrice() , person.getQty() , person.getDescription()) > 0;
	}
	
	
}
