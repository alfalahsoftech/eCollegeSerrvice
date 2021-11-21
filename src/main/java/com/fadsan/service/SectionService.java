package com.fadsan.service;

import java.util.List;

import com.fadsan.model.Section;
import com.fadsan.models.dto.SectionDTO;

public interface SectionService extends CRUDService<Integer, Section> {

	List<SectionDTO> getSectionListByClassId(int classId);

	List<SectionDTO> getSections();

	SectionDTO getSectionById(int sectionId);

	SectionDTO getSectionByClassIdAndSectionName(int classId, String sectionName);

}
