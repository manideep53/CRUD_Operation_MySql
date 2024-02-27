

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {
	


	public static void main(String[] args) throws SQLException {
		
		EmployeeCRUD ec = new EmployeeCRUD();
//		ec.allData();
		
            
	            
		
		
		
		System.out.println("Please select an Option:");
		System.out.println("option 1:: INSERT DATA");
		System.out.println("option 2:: UPDATE DATA ");
		System.out.println("option 3:: DELETE DATA");
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		
		switch(option) {
		
		case 1:
			System.out.println("Please ENter empId..........");
			int empId = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Please ENter empName..........");
			String empName = sc.nextLine();
			
			
			System.out.println("Please ENter empSalary.........");
			double empSalary = sc.nextDouble();
			
			Employee e =  new Employee();
			
			
			
			e.setEmployee_Id(empId);
			e.setEmployee_Name(empName);
			e.setEmployee_Salary(empSalary);
			
			
			try {
				EmployeeCRUD empc = new EmployeeCRUD();
				empc.insertData(e);
				System.out.println("Data Inserted Sucessfully...........");
			ec.allData();
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			break;	
			
		case 2:
			
			System.out.println("Please Enter empId to update..........");
	        int empId1 = sc.nextInt();

	        Employee e1 = new Employee();
	        e1.setEmployee_Id(empId1);

	        try {
	            EmployeeCRUD empc = new EmployeeCRUD();

	            Employee existingEmployee = empc.getEmployeeById(empId1);

	            if (existingEmployee != null) {
	                System.out.println("Existing Data:");
	                System.out.println(existingEmployee.toString());

	                
	                System.out.println("Please Enter empName for update..........");
	                sc.nextLine(); 
	                String updatedName = sc.nextLine();
	                existingEmployee.setEmployee_Name(updatedName);
	                empc.updateData(existingEmployee);
	                System.out.println("Data Updated Successfully...........");
		ec.allData();

	                
	               
	            } else {
	                System.out.println("Employee with ID " + empId1 + " not found.");
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
			
			break;
			
		case 3:
			
			System.out.println("Please Enter empId to delete..........");
	        int empId11 = sc.nextInt();

	        Employee e11 = new Employee();
	        e11.setEmployee_Id(empId11);

        
	        
	        EmployeeCRUD empc = new EmployeeCRUD();

            Employee existingEmployee = empc.getEmployeeById(empId11);
            if (existingEmployee != null) {
        empc.deleteData(existingEmployee);
        System.out.println("Data Deleted Successfully...........");
        ec.allData();
        }
            else {
                System.out.println("Employee with ID " + empId11 + " not found.");
            }
			
			break;
			
			default:
				System.out.println("Please Enter valid Number.....");
			
		}
		
	            
		
		
		
		
	    }
	
		

	}

