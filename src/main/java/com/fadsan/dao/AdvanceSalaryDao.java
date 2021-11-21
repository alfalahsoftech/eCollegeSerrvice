package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.AdvanceSalary;

public interface AdvanceSalaryDao extends DAO<Integer, AdvanceSalary> {

	List<AdvanceSalary> findAdvancebyEmployeeId(int employeeId, int sessionId);

	List<AdvanceSalary> findAdvanceformonth(int sessionId, Integer monthId,
			int employeeId);

	List<AdvanceSalary> getTodaysAdvance(Date frmDate, Date toDate);

	List<AdvanceSalary> getTodaysAdvance(Date Date);

	List<AdvanceSalary> getByPageNo(int pageNo);

}
