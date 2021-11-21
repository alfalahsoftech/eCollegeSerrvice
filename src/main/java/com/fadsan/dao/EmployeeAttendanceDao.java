package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.EmployeeAttendance;

public interface EmployeeAttendanceDao extends DAO<Integer, EmployeeAttendance> {

	List<EmployeeAttendance> getRegisterByEmployeeId(Integer employeeId,
			Date frmDate, Date tDate);

	EmployeeAttendance getAttendanceReportByIdDate(int id, java.sql.Date sDate);

	List<EmployeeAttendance> getEmployeeAttendanceList(int employeeId,
			Date frmDate, Date tDate);

	List<Date> totalSchoolOpenDays(Date frmDate, Date tDate);

}
