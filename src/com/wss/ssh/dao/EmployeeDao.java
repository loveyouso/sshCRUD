package com.wss.ssh.dao;

import java.util.List;
import org.hibernate.Query;
import com.wss.ssh.entities.Employee;

public class EmployeeDao extends BaseDao {
	
	public void delete(Integer id) {
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public List<Employee> getAll(){
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	public void saveOruUdate(Employee employee) {
		getSession().saveOrUpdate(employee);
	}
	
	public Employee getEmployeeFromLastName(String lastName) {
		String hql = "FROM Employee e WHERE e.lastName = ?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		return (Employee) query.uniqueResult();
	}
	
	public Employee get(Integer id) {
		return (Employee) getSession().get(Employee.class, id);
	}
}
