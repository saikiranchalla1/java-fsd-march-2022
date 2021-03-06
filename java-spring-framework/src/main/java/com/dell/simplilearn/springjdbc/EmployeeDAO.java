package com.dell.simplilearn.springjdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}




	public int saveEmployee(EmployeeJDBC e) {
		String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}
	
	public int updateEmployee(EmployeeJDBC e) {
		// String query = "UPDATE employees set name = '" +  e.getName() + , salary = e.getSalary() where id = e.getId()";
		
		String query = String.format("UPDATE employee set name = '%s', salary = %f where id = %d ", e.getName(), e.getSalary(), e.getId());
		return jdbcTemplate.update(query);		
	}
	
	public int deleteEmployee(EmployeeJDBC e) {
		String query = String.format("DELETE FROM employee where id = %d", e.getId());
		
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveEmployeeByPreparedStatement(final EmployeeJDBC e) {
		String query = "insert into employee values(?,?,?)";
		
		
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setFloat(3, e.getSalary());
				
				return ps.execute();
			}
		});
	}
	
	
	public List<EmployeeJDBC> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<EmployeeJDBC>>() {

			public List<EmployeeJDBC> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<EmployeeJDBC> list = new ArrayList<EmployeeJDBC>();
				
				while (rs.next()) {
					EmployeeJDBC e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3));
					list.add(e);
				}
				
				return list;
			}
			
		});
	}
	
	
	public List<EmployeeJDBC> getAllEmployeesRowMapper() {
		return jdbcTemplate.query("select * from employee", new RowMapper<EmployeeJDBC>() {

			public EmployeeJDBC mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
		});
	}
	
	
	public void save(EmployeeJDBC e) {
		String query = "insert into employee values(:id, :name, :salary)";
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", e.getId());
		map.put("name", e.getName());
		map.put("salary", e.getSalary());
		
		
		template.execute(query, map, new PreparedStatementCallback<Object>() {

			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}
			
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
