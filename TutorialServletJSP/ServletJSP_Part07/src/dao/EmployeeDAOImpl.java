package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	//private static final String INSERT_EMPLOYEE = "insert into employee(name,surname,salary)values(?,?,?)";
	private static final String ALL_EMPLOYEES = "select*from employee";
	private static final String DELETE_EMPLOYEE = "delete from employee where id=?";

	private DataSource getDataSource() {
		ConnectionManager manager = new ConnectionManager();
		DataSource dataSource = manager.getMySQLDataSource();
		return dataSource;
	}

	@Override
	public void insertEmployee(String name, String surname, String salary) {
		
		DataSource dataSource = getDataSource();
		String query = "insert into employee(name,surname,salary)values('"+name+"','"+surname+"','"+salary+"')";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			/*ps.setString(1, name);
			ps.setString(2, surname);
			ps.setInt(3, salary); */
			ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployees() {
		DataSource dataSource = getDataSource();
		Connection connection;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(ALL_EMPLOYEES);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String salary = resultSet.getString("salary");
				// bundan employee objesi oluşturabiliriz.

				Employee employee = new Employee(id, name, surname, salary);
				// geriye list dönücem.
				employees.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;

	}

	@Override
	public void removeEmployee(int id) {
		DataSource dataSource = getDataSource();
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(DELETE_EMPLOYEE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
