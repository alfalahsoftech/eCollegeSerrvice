package com.fadsan.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.fadsan.model.EmployeeAttendance;
import com.fadsan.models.dto.EmployeeAttendanceDTO;
import com.fadsan.models.dto.EmployeesDTO;

public interface EmployeeAttendanceService extends
		CRUDService<Integer, EmployeeAttendance> {

	List<EmployeesDTO> getEmployeeRegister() throws ParseException;

	void setEmployeeAttendance(int id, String status, String currentDate)
			throws ParseException;

	List<EmployeesDTO> showEmployeeAttendanceRecord(String fromDate,
			String toDate) throws ParseException;

	List<EmployeesDTO> showEmployeeAttendanceRecordAsPdf(String fromDate,
			String toDate, int empId) throws ParseException;

	List<EmployeeAttendanceDTO> getMonthlyReport(Integer id, int monthId)
			throws ParseException;

	List<EmployeeAttendanceDTO> getCurrentDateData(String currentDate)
			throws ParseException;

	List<EmployeeAttendanceDTO> getEmployeeSummuary() throws ParseException;

	Map<String, Object> getAttendaceDataForEmp(int empId, int monthId, int year) throws Exception;

}
