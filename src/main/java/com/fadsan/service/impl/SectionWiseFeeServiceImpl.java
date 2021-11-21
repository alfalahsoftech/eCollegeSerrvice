package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.entitytodtoconvertor.SectionWiseFeeEntityToDTO;
import com.fadsan.dao.FeesCategoriesDao;
import com.fadsan.dao.MonthDao;
import com.fadsan.dao.SectionDao;
import com.fadsan.dao.SectionWiseFeeDao;
import com.fadsan.dao.SessionDao;
import com.fadsan.dao.StudentClassesDao;
import com.fadsan.dao.StudentFeeSubmissionDetailsDao;
import com.fadsan.model.SectionWiseFee;
import com.fadsan.model.Session;
import com.fadsan.model.StudentFeeSubmissionDetails;
import com.fadsan.models.dto.SectionWiseFeeDTO;
import com.fadsan.service.SectionWiseFeeService;

@Transactional
@Service("sectionWiseFeeService")
public class SectionWiseFeeServiceImpl extends
		CRUDServiceImpl<Integer, SectionWiseFee, SectionWiseFeeDao> implements
		SectionWiseFeeService {
	@Autowired
	public SectionWiseFeeServiceImpl(SectionWiseFeeDao dao) {
		super(dao);
	}

	@Autowired
	FeesCategoriesDao feesCategoriesDao;
	@Autowired
	MonthDao monthDao;
	@Autowired
	SessionDao sessionDao;
	@Autowired
	StudentClassesDao classDao;
	@Autowired
	SectionDao sectionDao;
	@Autowired
	StudentFeeSubmissionDetailsDao studentFeeSubmissionDetailsDao;


	@Override
	public String saveSectionWiseFee(SectionWiseFeeDTO sectionWiseFeeDTO) {
		String status="no";
		List<StudentFeeSubmissionDetails> fees=new ArrayList<StudentFeeSubmissionDetails>();
		if(sectionWiseFeeDTO.getMonthId()==13)
		{
			  fees=studentFeeSubmissionDetailsDao.getSubmissionforsection(sectionWiseFeeDTO.getSessionId(),sectionWiseFeeDTO.getClassId(),sectionWiseFeeDTO.getSectionId());
		}
		else
		{
	   fees=studentFeeSubmissionDetailsDao.getSubmissionforsectioninMonth(sectionWiseFeeDTO.getSessionId(),sectionWiseFeeDTO.getClassId(),sectionWiseFeeDTO.getSectionId(),sectionWiseFeeDTO.getMonthId());
	
		}if(fees.isEmpty())
		{
		SectionWiseFee fee = new SectionWiseFee();
		fee.setActive(true);
		fee.setFeeAmount(Double.parseDouble(sectionWiseFeeDTO.getFeeAmount()));
		fee.setFeesCategories(feesCategoriesDao.get((sectionWiseFeeDTO
				.getFeesCategoriesId())));
		fee.setMonth(monthDao.get(sectionWiseFeeDTO.getMonthId()));
		fee.setSession(sessionDao.get(sectionWiseFeeDTO.getSessionId()));
		fee.setClasses(classDao.get(sectionWiseFeeDTO.getClassId()));
		fee.setSection(sectionDao.get(sectionWiseFeeDTO.getSectionId()));
		dao.create(fee);
		status="yes";
		}
		return status;

	}

	@Override
	public List<SectionWiseFeeDTO> getSectionWiseFee(int sessionId,
			int classId, Integer[] monthId, int categoryId, int sectionId) {
		List<SectionWiseFee> sectionWiseFee = dao.getSectionWiseFee(sessionId,
				classId, monthId, categoryId, sectionId);
		SectionWiseFeeEntityToDTO sectionWiseFeeEntityToDTO = SectionWiseFeeEntityToDTO
				.getInstance();
		List<SectionWiseFeeDTO> sectionWiseFeeDTOs = new ArrayList<SectionWiseFeeDTO>();
		for (SectionWiseFee sectionWiseFee2 : sectionWiseFee) {
			sectionWiseFeeDTOs.add(sectionWiseFeeEntityToDTO
					.convertEntityToDTO(sectionWiseFee2));
		}
		return sectionWiseFeeDTOs;
	}

	@Override
	public List<SectionWiseFeeDTO> getAllSectionFees() {
		List<SectionWiseFee> fee = dao
				.findAllByIsActiveTrue(SectionWiseFee.class);
		List<SectionWiseFeeDTO> lists = new ArrayList<SectionWiseFeeDTO>();
		for (SectionWiseFee fees : fee) {
			SectionWiseFeeDTO dto = new SectionWiseFeeDTO();
			dto.setSectionWiseFeeId(fees.getSectionWiseFeeId());
			dto.setSectionName(sectionDao.get(fees.getSection().getSectionId())
					.getSectionName());
			dto.setClassName(classDao.get(fees.getClasses().getClassId())
					.getClassName());
			dto.setSessionName(sessionDao.get(fees.getSession().getSessionId())
					.getSessionDuration());
			dto.setFeeAmount(String.valueOf(fees.getFeeAmount()));
			dto.setFeesCategoriesName(feesCategoriesDao.get(
					fees.getFeesCategories().getFeeCategoryId())
					.getFeeCategoryName());
			dto.setMonthName(monthDao.get(fees.getMonth().getMonthId())
					.getMonthName());
			lists.add(dto);
		}
		return lists;
	}

	@Override
	public void setActiveById(int id) {
		dao.get(id).setActive(false);

	}

	public List<SectionWiseFeeDTO> getSectionWiseFeeAllotementBySectionId(
			int sessionId, int classId, int sectionId) {
		List<SectionWiseFee> sectionWiseFees = dao
				.getSectionWiseFeeAllotmentBysectionId(sessionId, classId,
						sectionId);
		List<SectionWiseFeeDTO> list = new ArrayList<SectionWiseFeeDTO>();
		SectionWiseFeeEntityToDTO entityToDTO = new SectionWiseFeeEntityToDTO();
		for (SectionWiseFee fee : sectionWiseFees) {
			list.add(entityToDTO.convertEntityToDTO(fee));
		}
		return list;
	}

	@Override
	public String deleteAllotedFeesCategory(int classId, int monthId,
			int sectionId, int sectionWiseFeeId) {
		Session current = sessionDao.findCurrentSession();
		List<StudentFeeSubmissionDetails> feeSubmissionDetails;

		if (monthId == 13) {
			Integer[] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
			feeSubmissionDetails =  studentFeeSubmissionDetailsDao
					.getFeeSubmissionStatus(current.getSessionId(), classId,
							sectionId, months);

		} else {

			Integer[] months = { monthId };
			feeSubmissionDetails = studentFeeSubmissionDetailsDao
					.getFeeSubmissionStatus(current.getSessionId(), classId,
							sectionId, months);
		}
		if (feeSubmissionDetails == null || feeSubmissionDetails.isEmpty())

		{
			dao.deleteById(sectionWiseFeeId);
			return "true";
		} else
			return "false";

	}
	}

