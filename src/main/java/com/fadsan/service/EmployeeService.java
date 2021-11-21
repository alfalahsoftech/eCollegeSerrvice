package com.fadsan.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.fadsan.model.Employees;
import com.fadsan.models.dto.EmployeeSalaryDTO;
import com.fadsan.models.dto.EmployeesDTO;
import com.fadsan.models.dto.FeecategoryAmountDTO;

public interface EmployeeService extends CRUDService<Integer, Employees> {

	public int saveEmployeeRegistration(EmployeesDTO employeesDTO)
			throws Exception, MessagingException;

	public List<EmployeesDTO> getEmployeesbyFirstname(String firstName);

	public void setActiveById(int id);

	public EmployeesDTO findEmployeeDetails(int id);

	public void updateEmployeesdata(EmployeesDTO employeeDTO)
			throws ParseException;

	public EmployeesDTO finddetailsbyuserId(Integer id);

	public Map<String, Object> getActiveEmployeeList() throws Exception;

	public Map<String, Object> getActiveEmployeesDateWiseAttendance(String date )throws ParseException;

	public String changeemployeepassword(
			FeecategoryAmountDTO feecategoryAmountDTO);

	public List<EmployeesDTO> findAllEmployee();

	public  List<EmployeesDTO> findAllEmployeeDetails();

	public void submitsalary(EmployeesDTO employeeDTO);

	
	


}
