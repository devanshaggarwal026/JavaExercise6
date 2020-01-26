package com.robomq.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Person person = new Person();
		person.setName(resultSet.getString("name"));
		person.setQty(resultSet.getInt("qty"));
		person.setDescription(resultSet.getString("description"));
		person.setPrice(resultSet.getInt("price"));
		person.setId(resultSet.getInt("id"));
		return person;
		
	}
	

	
}
