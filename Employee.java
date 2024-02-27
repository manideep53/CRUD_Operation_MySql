

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	
	private int employee_Id;
	private String employee_Name;
	private double employee_Salary;
	
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int employee_Id, String employee_Name, double employee_Salary) {
		super();
		this.employee_Id = employee_Id;
		this.employee_Name = employee_Name;
		this.employee_Salary = employee_Salary;
	}

	public Employee(int employee_Id, String employee_Name) {
		super();
		this.employee_Id = employee_Id;
		this.employee_Name = employee_Name;
		
	}

	public Employee(ResultSet rs) throws SQLException {
		this.employee_Id= rs.getInt("employee_Id");
		this.employee_Name= rs.getString("employee_Name");
		this.employee_Salary = rs.getDouble( "employee_Salary");
	}


	public int getEmployee_Id() {
		return employee_Id;
		
	}


	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}


	public String getEmployee_Name() {
		return employee_Name;
	}


	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}


	public double getEmployee_Salary() {
		return employee_Salary;
	}


	public void setEmployee_Salary(double employee_Salary) {
		this.employee_Salary = employee_Salary;
	}


	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_Salary="
				+ employee_Salary + "]";
	}
	
	

}
