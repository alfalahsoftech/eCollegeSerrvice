package com.fadsan.service;

import java.util.List;

import com.fadsan.model.SectionWiseFee;
import com.fadsan.models.dto.SectionWiseFeeDTO;

public interface SectionWiseFeeService extends
		CRUDService<Integer, SectionWiseFee> {

	String saveSectionWiseFee(SectionWiseFeeDTO sectionWiseFeeDTO);

	List<SectionWiseFeeDTO> getSectionWiseFee(int sessionId, int classId,
			Integer[] monthId, int categoryId, int sectionId);

	List<SectionWiseFeeDTO> getAllSectionFees();

	List<SectionWiseFeeDTO> getSectionWiseFeeAllotementBySectionId(
			int sessionId, int classId, int sectionId);

	void setActiveById(int id);

	String deleteAllotedFeesCategory(int classId, int monthId, int sectionId,
			int sectionWiseFeeId);

}
