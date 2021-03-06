package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.ClassWiseFeeDao;
import com.fadsan.dao.EditFeeAmountDao;
import com.fadsan.dao.FeesCategoriesDao;
import com.fadsan.dao.SectionWiseFeeDao;
import com.fadsan.dao.StudentFeeSubmissionDetailsDao;
import com.fadsan.dao.StudentWiseFeeDao;
import com.fadsan.model.ClassWiseFee;
import com.fadsan.model.EditFeeAmount;
import com.fadsan.model.FeesCategories;
import com.fadsan.model.SectionWiseFee;
import com.fadsan.model.StudentFeeSubmissionDetails;
import com.fadsan.model.StudentWiseFee;
import com.fadsan.models.dto.FeesCategoriesDTO;
import com.fadsan.service.FeesCategoriesService;

@Transactional
@Service("feesCategoriesService")
public class FeesCategoriesServiceImpl extends
		CRUDServiceImpl<Integer, FeesCategories, FeesCategoriesDao> implements
		FeesCategoriesService {

	@Autowired
	public FeesCategoriesServiceImpl(FeesCategoriesDao dao) {
		super(dao);

	}

	@Autowired
	private StudentFeeSubmissionDetailsDao studentFeeSubmissionDetailsDao;
	@Autowired
	private ClassWiseFeeDao classWiseFeeDao;
	@Autowired
	private EditFeeAmountDao editFeeAmountDao;
	@Autowired
	private SectionWiseFeeDao sectionWiseFeeDao;
	@Autowired
	private StudentWiseFeeDao studentWiseFeeDao;

	@Override
	public FeesCategoriesDTO getFeeCategoriesDTOById(int feeCategoryId) {
		FeesCategories fees = dao.get(feeCategoryId);
		FeesCategoriesDTO dto = new FeesCategoriesDTO();
		dto.setFeeCategoryId(fees.getFeeCategoryId());
		dto.setFeeCategoryName(fees.getFeeCategoryName());
		return dto;
	}

	@Override
	public void createFeeCategories(FeesCategoriesDTO feeCategoryDTO) {
		FeesCategories fee = new FeesCategories();
		fee.setActive(true);
		fee.setFeeCategoryId(feeCategoryDTO.getFeeCategoryId());
		fee.setFeeCategoryName(feeCategoryDTO.getFeeCategoryName());
		dao.create(fee);

	}

	@Override
	public void updateFeeCategories(FeesCategoriesDTO feeCategoryDTO) {
		FeesCategories feeCategory = dao.get(feeCategoryDTO.getFeeCategoryId());
		feeCategory.setFeeCategoryName(feeCategoryDTO.getFeeCategoryName());
		dao.update(feeCategory);

	}

	@Override
	public String verifyduplicatename(String name) {
		String var = "false";
		FeesCategories feeCategory = dao.getverifiedname(name);
		if (feeCategory == null) {
			var = "true";
		}
		return var;

	}

	@Override
	public List<FeesCategoriesDTO> getFeesCategories(String studentAdmissionNo,
			int recieptNo) {
		List<FeesCategoriesDTO> feeslist = new ArrayList<FeesCategoriesDTO>();
		List<StudentFeeSubmissionDetails> studentFeeSubmissionDetailsList = studentFeeSubmissionDetailsDao
				.getSingleFeeSubmissionBySlipNo(recieptNo);
		int totalfine = 0;
		double feecategoryamount = 0;
		for (FeesCategories feescatg : dao
				.findAllByIsActiveTrue(FeesCategories.class)) {
			String fine = "Fine";
			FeesCategoriesDTO feescatgdto = new FeesCategoriesDTO();

			if (feescatg.getFeeCategoryName().equals(fine))
				feecategoryamount = totalfine;
			feescatgdto.setFeeCategoryName(feescatg.getFeeCategoryName());
			for (StudentFeeSubmissionDetails studentFeeSubmissionDetails : studentFeeSubmissionDetailsList) {
				int sectionId = studentFeeSubmissionDetails.getSection()
						.getSectionId();
				int classId = studentFeeSubmissionDetails.getStudentClasses()
						.getClassId();
				int sessionId = studentFeeSubmissionDetails.getSession()
						.getSessionId();
				for (Integer integer : studentFeeSubmissionDetailsDao
						.getMonthIdsBySlipNo(recieptNo)) {
					for (ClassWiseFee classWiseFees : classWiseFeeDao
							.getFeeAllotement(sessionId, classId, integer)) {
						if (classWiseFees != null) {
							EditFeeAmount editFeeAmount = editFeeAmountDao
									.getDiscountAmountBySessionMonthCategoryId(
											sessionId,
											integer,
											classWiseFees.getFeesCategories()
													.getFeeCategoryId(),
											Integer.parseInt(studentAdmissionNo));
							if (feescatg.getFeeCategoryName() == classWiseFees
									.getFeesCategories().getFeeCategoryName()) {
								if (editFeeAmount == null) {
									feecategoryamount += classWiseFees
											.getFeeAmount();
								} else {
									feecategoryamount += (classWiseFees
											.getFeeAmount() - editFeeAmount
											.getDiscount());
								}
							}
						}

					}
					for (SectionWiseFee sectionWiseFee : sectionWiseFeeDao
							.getFeeAllotement(sessionId, classId, sectionId,
									integer)) {
						if (sectionWiseFee != null) {
							if (feescatg.getFeeCategoryName() == sectionWiseFee
									.getFeesCategories().getFeeCategoryName()) {
								EditFeeAmount editFeeAmount = editFeeAmountDao
										.getDiscountAmountBySessionMonthCategoryId(
												sessionId,
												integer,
												sectionWiseFee
														.getFeesCategories()
														.getFeeCategoryId(),
												Integer.parseInt(studentAdmissionNo));
								if (editFeeAmount == null) {
									feecategoryamount += sectionWiseFee
											.getFeeAmount();
								} else {
									feecategoryamount += (sectionWiseFee
											.getFeeAmount() - editFeeAmount
											.getDiscount());
								}
							}
						}
					}
					for (StudentWiseFee studentWiseFee : studentWiseFeeDao
							.getFeeAllotement(sessionId, classId, sectionId,
									integer, studentAdmissionNo)) {
						if (studentWiseFee != null) {
							if (feescatg.getFeeCategoryName() == studentWiseFee
									.getFeesCategories().getFeeCategoryName()) {
								EditFeeAmount editFeeAmount = editFeeAmountDao
										.getDiscountAmountBySessionMonthCategoryId(
												sessionId,
												integer,
												studentWiseFee
														.getFeesCategories()
														.getFeeCategoryId(),
												Integer.parseInt(studentAdmissionNo));
								if (editFeeAmount == null) {
									feecategoryamount += studentWiseFee
											.getFeeAmount();
								} else {
									feecategoryamount += (studentWiseFee
											.getFeeAmount() - editFeeAmount
											.getDiscount());
								}
							}
						}
					}
				}
			}
			if (feecategoryamount == 0.0 || feecategoryamount == 0)
				feescatgdto.setAmounts("");
			else
				feescatgdto.setAmounts(String.valueOf(feecategoryamount));
			feeslist.add(feescatgdto);

		}
		return feeslist;
	}

}
