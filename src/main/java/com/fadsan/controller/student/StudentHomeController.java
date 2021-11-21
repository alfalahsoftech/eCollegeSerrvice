package com.fadsan.controller.student;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fadsan.common.constant.SessionConstants;
import com.fadsan.model.User;
import com.fadsan.models.dto.MonthDTO;
import com.fadsan.models.dto.StudentDTO;
import com.fadsan.service.AnnualExamReportService;
import com.fadsan.service.MonthService;
import com.fadsan.service.MonthlyExamReportService;
import com.fadsan.service.StudentsAdmissionService;

@Controller
@RequestMapping(value = "/student/**")
public class StudentHomeController {
	@Autowired
	StudentsAdmissionService admissionService;
	@Autowired
	MonthService monthService;
	@Autowired
	private MonthlyExamReportService monthlyExamReportService;
	@Autowired
	private AnnualExamReportService annualExamReportService;

	@RequestMapping(value = "/student-profile", method = RequestMethod.GET)
	public String showStudentDetails(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.USER_INFO);
		StudentDTO studentDTO = admissionService
				.getStudentProfile(user.getId());
		model.addAttribute("StudentDetailsBean", studentDTO);
		return "showstudentdetails";
	}

	@RequestMapping(value = "/attendancestu-report.html", method = RequestMethod.GET)
	public String showAttendanceReport(Model model) {
		List<MonthDTO> monthList = monthService.getMonthInOrder();
		model.addAttribute("monthList", monthList);
		return "attendancereport";
	}
	@RequestMapping(value = "my-monthly-exam-report.html", method = RequestMethod.GET)
	public String viewMonthlyExamReport(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.USER_INFO);
		StudentDTO studentDTO = admissionService
				.getStudentProfile(user.getId());
		Map<String, Object> map=monthlyExamReportService.getMonthlyExamReport(studentDTO.getSessionId(), studentDTO.getClassId(), studentDTO.getSectionId(),
				studentDTO.getAdmissionNo());
		model.addAttribute("map", map);
		return "mymonthlyexamreport";
	}
	@RequestMapping(value = "view-my-report-cards.html", method = RequestMethod.GET)
	public String getStudentReportCardPage(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.USER_INFO);
		StudentDTO studentDTO = admissionService
				.getStudentProfile(user.getId());
		Map<String, Object> map=annualExamReportService.getDataForGenerateReportCard(studentDTO.getSessionId(), studentDTO.getClassId(), studentDTO.getSectionId(),
				studentDTO.getAdmissionNo());
		model.addAttribute("map", map);
		return "myreportcard";
	}
}
