package com.jacoblindev.mysqldemo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.jacoblindev.mysqldemo.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeJDBCRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            return employee;
        }
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
    }

    public Optional<Employee> findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from employees where id=?",
                new BeanPropertyRowMapper<Employee>(Employee.class), id));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from employees where id=?", id);
    }

    public int insert(Employee employee) {
        return jdbcTemplate.update(
                "insert into employees (id, emp_id, first_name, last_name, email) " + "values(?, ?, ?, ?, ?)",
                employee.getId(), employee.getEmpId(), employee.getFirstName(), employee.getLastName(),
                employee.getEmail());
    }

    public int update(Employee employee) {
        return jdbcTemplate.update(
                "update employees " + " set emp_id = ?, first_name = ?, last_name = ?, email = ? " + " where id = ?",
                employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getId());
    }

}
