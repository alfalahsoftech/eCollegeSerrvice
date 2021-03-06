package com.fadsan.controller.examreport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fadsan.common.constant.CommonConstants;
import com.fadsan.model.Session;
import com.fadsan.models.dto.AnnualExamReportDTO;
import com.fadsan.models.dto.StudentClassesDTO;
import com.fadsan.service.AnnualExamReportService;
import com.fadsan.service.AnnualExamTotalGainMarksService;
import com.fadsan.service.AssignClassService;
import com.fadsan.service.MonthService;
import com.fadsan.service.SessionService;
import com.fadsan.service.StudentClassesService;
import com.fadsan.service.StudentsAdmissionService;

@Controller
@RequestMapping({ "/admin/**", "/employee/**" ,"/branch/**"})
public class FinalExamRecodsController {
	@Autowired
	private SessionService sessionService;
	@Autowired
	private StudentClassesService studentClassesService;
	@Autowired
	private MonthService monthService;
	@Autowired
	private AnnualExamReportService annualExamReportService;
	@Autowired
	private AnnualExamTotalGainMarksService annualExamTotalGainMarksService;
	@Autowired
	private AssignClassService assignClassService;
	@Autowired
	private StudentsAdmissionService studentService;

	@RequestMapping(value = "final-exam-menu-page.html", method = RequestMethod.GET)
	public String finalExamMenuPage() {
		return "finalexammenupage";
	}

	@RequestMapping(value = "assign-annual-marks-to-student.html", method = RequestMethod.GET)
	public String assignAnnaulExamMarksPage(ModelMap model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute(CommonConstants.ROLE);

		if (ROLE.equals("ROLE_EMPLOYEE")) {
			Integer employeeId = (Integer) session
					.getAttribute(CommonConstants.EMPLOYER_ID);
			StudentClassesDTO studentClassesDTO = assignClassService
					.getAssignClassAndSection(employeeId);
			model.addAttribute("StudentClassesDTO", studentClassesDTO);
			model.addAttribute("CLASSID", studentClassesDTO.getClassId());
			model.addAttribute("SECTIONID", studentClassesDTO.getSectionId());
		} else {
			model.addAttribute("classesList",
					studentClassesService.getAllClass());
		}
		model.addAttribute("sessionList",
				sessionService.findAll(Session.class));
		model.addAttribute("ROLE", ROLE);
		model.addAttribute("current", sessionService.findCurrent());
		model.addAttribute("CURRENTSESSIONID", sessionService.findCurrent().getSessionId());
		model.addAttribute("monthList",
				monthService.getMonthInOrderToSerialNo());
		model.addAttribute("AnnualExamReportDTO", new AnnualExamReportDTO());
		return "assignmarkspage";
	}

	@RequestMapping(value = "assign-annual-marks-to-student.html", method = RequestMethod.POST)
	public String saveAnnaulExamMarks(
			@ModelAttribute AnnualExamReportDTO annualExamReportDTO,
			ModelMap model,RedirectAttributes redirectAttributes) {
		annualExamReportService.saveAnnualExamReport(annualExamReportDTO);
		annualExamTotalGainMarksService
				.saveAnnualExamTotalGainMarks(annualExamReportDTO);
		/*model.addAttribute("sessionList", sessionService.findAll(Session.class));
		model.addAttribute("current", sessionService.findCurrent());
		model.addAttribute("classesList", studentClassesService.getAllClass());
		model.addAttribute("monthList",
				monthService.getMonthInOrderToSerialNo());
		model.addAttribute("msg",
				"Subject Marks Assigned To Student Successfully");
		model.addAttribute("AnnualExamReportDTO", new AnnualExamReportDTO());*/
		redirectAttributes.addFlashAttribute("msg", "Subject Marks Assigned To Student Successfully");
		return "redirect:assign-annual-marks-to-student.html";
	}

	@RequestMapping(value = "view-student-report-cards.html", method = RequestMethod.GET)
	public String getStudentReportCardPage(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String ROLE = (String) session.getAttribute(CommonConstants.ROLE);

		if (ROLE.equals("ROLE_EMPLOYEE")) {
			Integer employeeId = (Integer) session
					.getAttribute(CommonConstants.EMPLOYER_ID);
			StudentClassesDTO studentClassesDTO = assignClassService
					.getAssignClassAndSection(employeeId);
			model.addAttribute("StudentClassesDTO", studentClassesDTO);
			model.addAttribute("CLASSID", studentClassesDTO.getClassId());
			model.addAttribute("SECTIONID", studentClassesDTO.getSectionId());
		} else {
			model.addAttribute("classesList",
					studentClassesService.getAllClass());
		}
		model.addAttribute("sessionList",
				sessionService.findAll(Session.class));
		model.addAttribute("ROLE", ROLE);
		model.addAttribute("current", sessionService.findCurrent());
		model.addAttribute("CURRENTSESSIONID", sessionService.findCurrent().getSessionId());
		return "viewstudentreportcard";
	}

	@RequestMapping(value = "generate-student-report-card-pdf.html", method = RequestMethod.GET)
	public String ganerateStudentResultPDF(@RequestParam int sessionId,
			@RequestParam int classId, @RequestParam int sectionId,
			@RequestParam String studentId, ModelMap model) {
		model.addAttribute("map", annualExamReportService
				.getDataForGenerateReportCard(sessionId, classId, sectionId,
						studentId));
		model.addAttribute("Student", studentService.findStudentDetails(studentId));
		return "studentreportcardpdf";
	}

}
