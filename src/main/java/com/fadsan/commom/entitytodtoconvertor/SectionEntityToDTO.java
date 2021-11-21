package com.fadsan.commom.entitytodtoconvertor;

import java.util.ArrayList;
import java.util.List;

import com.fadsan.model.Section;
import com.fadsan.models.dto.SectionDTO;

public class SectionEntityToDTO {
	public static List<SectionDTO> sectionEntityToDTO(List<Section> sectionList) {
		List<SectionDTO> sectionDTOs = new ArrayList<SectionDTO>();
		for (Section section : sectionList) {
			SectionDTO sectionDTO = new SectionDTO();
			sectionDTO.setClassName(section.getStudentClasses().getClassName());
			sectionDTO.setSectionName(section.getSectionName());
			sectionDTO.setSectionId(section.getSectionId());
			sectionDTOs.add(sectionDTO);
		}
		return sectionDTOs;
	}
	
}
