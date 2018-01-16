package org.viggie.spring2;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import org.viggie.spring1.Employee;

public class EmployeeDAO {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(Employee p){  
	    String sql="insert into employees(name,salary,designation)values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";  
	    return template.update(sql);  
	}  
	public int update(Employee p){  
	    String sql="update employees set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from employees where id="+id+"";  
	    return template.update(sql);  
	}  
	public Employee getEmpById(int id){  
	    String sql="select * from employees where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));  
	}  
	public List<Employee> getEmployees(){  
	    return template.query("select * from employees",new RowMapper<Employee>(){  
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
	            Employee e=new Employee();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setSalary(rs.getFloat(3));  
	            e.setDesignation(rs.getString(4));  
	            return e;  
	        }  
	    });  
	}

}
