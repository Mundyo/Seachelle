package seachelle.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import seachelle.entity.Customer;
import seachelle.entity.Employee;
import seachelle.entity.Seachelle;

@Data
@NoArgsConstructor
public class SeachelleData {
	private Long seachelleId;
	private String seachelleName;
	private String seachelleAddress;
	private String seachelleCity;
	private String seachelleState;
	private String seachelleZip;
	private String seachellePhone; 
	
	private Set<SeachelleCustomer> customers = new HashSet<>();
	private Set<SeachelleEmployee> employees = new HashSet<>();
	
	
	public SeachelleData(Seachelle seachelle) {
		seachelleId = seachelle.getSeachelleId();
		seachelleName = seachelle.getSeachelleName();
		seachelleAddress = seachelle.getSeachelleAddress();
		seachelleCity = seachelle.getSeachelleCity();
		seachelleState = seachelle.getSeachelleState();
		seachelleZip = seachelle.getSeachelleZip();
		seachellePhone = seachelle.getSeachellePhone();
		
		
		for(Employee employee:seachelle.getEmployees()) {
			employees.add(new SeachelleEmployee(employee));
		}
		
		for(Customer customer :seachelle.getCustomers()) {
			customers.add(new SeachelleCustomer(customer));
			}
	}
	
	@Data
	@NoArgsConstructor
	public static class SeachelleCustomer{
		private Long customerId;
		private String customerFirstName; 
		private String customerLastName;
		private String customerEmail; 
		
		public SeachelleCustomer(Customer customer) {
			customerId = customer.getCustomerId();
			customerFirstName = customer.getCustomerFirstName();
			customerLastName = customer.getCustomerLastName();
			customerEmail = customer.getCustomerEmail();
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class SeachelleEmployee{
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeePhone;
		private String employeeJobTitle;
		
		public SeachelleEmployee(Employee employee) {
			employeeId = employee.getEmployeeId();
			employeeFirstName = employee.getEmployeeFirstName();
			employeeLastName = employee.getEmployeeLastName();
			employeePhone = employee.getEmployeePhone();
			employeeJobTitle = employee.getEmployeeJobTitle();		}
	}
}

