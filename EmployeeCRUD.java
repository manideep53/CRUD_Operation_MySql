

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeCRUD {
	
	private ArrayList<Employee> employee;
	private static  final String INSERT_DATA = "INSERT INTO employee values(?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM employee";
	private static final String UPDATE_EMP = "UPDATE employee set employee_Name = ? WHERE employee_id = ?";

	private static final String DELETE_EMP = "DELETE FROM employee WHERE employee_id = ?";
	
	private static final String SEARCH_BY_ID= "SELECT * From employee where employee_Id = ?";
	
	
	private Connection con;
	
	
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "kaniSolution";
	String driverName = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "Manideep@123";
	
//	public EmployeeCURD(Employee e) {
//		
//		// TODO Auto-generated constructor stub
//	}

	public void openConnection() throws SQLException {
		if (con==null || con.isClosed()) {
			con = DriverManager.getConnection(url+dbName,userName,password);
		}
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}

	
	public   void allData() throws SQLException{
		
		this.employee = new ArrayList<>();
		openConnection();
		PreparedStatement st = con.prepareStatement(SELECT_ALL);
		st.clearParameters();
		
		ResultSet rs = st.executeQuery();
		  while (rs.next()) {
              Employee emp = new Employee(rs);
              this.employee.add(emp);
              System.out.println("Employee ID: " + emp.getEmployee_Id());
              System.out.println("Employee Name: " + emp.getEmployee_Name());
              System.out.println("Employee Salary: " + emp.getEmployee_Salary());
              System.out.println("--------------------");
          }
		closeConnection();
		
		
		
		
	}
	
	public boolean insertData(Employee emp) throws SQLException {
		openConnection();
		PreparedStatement st = con.prepareStatement(INSERT_DATA);
		st.clearParameters();
		st.setInt(1,emp.getEmployee_Id());
		st.setString(2, emp.getEmployee_Name());
		st.setDouble(3, emp.getEmployee_Salary());
		st.executeUpdate();
		closeConnection();
		return false;
		
	}
	

	public boolean updateData(Employee emp) throws SQLException {
		openConnection();
		PreparedStatement st = con.prepareStatement(UPDATE_EMP);
		st.clearParameters();
		st.setString(1,emp.getEmployee_Name());
		st.setInt(2, emp.getEmployee_Id());
		int rowsAffected = st.executeUpdate();
		closeConnection();
		return rowsAffected>0;
		
	}
	
	
	public boolean deleteData(Employee emp) throws SQLException {
		openConnection();
		PreparedStatement st = con.prepareStatement(DELETE_EMP);
		st.clearParameters();
		st.setInt(1, emp.getEmployee_Id());
		st.executeUpdate();
		closeConnection();

		return false;

	}

	public Employee getEmployeeById(int empId) throws SQLException {
		Employee emp = null;
		openConnection();
		PreparedStatement st = con.prepareStatement(SEARCH_BY_ID);
		st.clearParameters();
		st.setInt(1, empId);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			emp = new Employee(rs.getInt("employee_Id"),rs.getString("employee_Name"),rs.getDouble("employee_Salary"));
		}
		closeConnection();
		return emp;
	}
	
	
	
}
