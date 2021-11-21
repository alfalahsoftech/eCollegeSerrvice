package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*import com.fadsan.commom.entitytodtoconvertor.SectionEntityToDTO;*/
import com.fadsan.dao.SectionDao;
import com.fadsan.model.Section;
import com.fadsan.model.StudentClasses;
import com.fadsan.models.dto.SectionDTO;
import com.fadsan.service.SectionService;

@Transactional
@Service("sectionService")
public class SectionServiceImpl extends
		CRUDServiceImpl<Integer, Section, SectionDao> implements SectionService {
	@Autowired
	public SectionServiceImpl(SectionDao dao) {
		super(dao);

	}

	@Override
	public List<SectionDTO> getSectionListByClassId(int classId) {
		List<SectionDTO> sectionDTOs = new ArrayList<SectionDTO>();
		for (Section section : dao.getSectionListByClassId(classId)) {
			SectionDTO sectionDTO = new SectionDTO();
			sectionDTO.setSectionName(section.getSectionName());
			sectionDTO.setSectionId(section.getSectionId());
			sectionDTOs.add(sectionDTO);
		}
		return sectionDTOs;
	}

	@Override
	public SectionDTO getSectionById(int sectionId) {
		Section section = dao.get(sectionId);
		SectionDTO sectionDTO = new SectionDTO();
		sectionDTO.setClassName(section.getStudentClasses().getClassName());
		sectionDTO.setClassId(section.getStudentClasses().getClassId());
		sectionDTO.setSectionName(section.getSectionName());
		sectionDTO.setSectionId(section.getSectionId());
		return sectionDTO;
	}

	@Override
	public List<SectionDTO> getSections() {
		List<Section> list = dao.findAll(Section.class);
		List<SectionDTO> sectionDTOs = new ArrayList<SectionDTO>();
		for (Section section : list) {
			SectionDTO sectionDTO = new SectionDTO();
			sectionDTO.setClassName(section.getStudentClasses().getClassName());
			sectionDTO.setSectionName(section.getSectionName());
			sectionDTO.setSectionId(section.getSectionId());
			sectionDTOs.add(sectionDTO);
		}
		return sectionDTOs;
	}

	@Override
	public SectionDTO getSectionByClassIdAndSectionName(int classId,
			String sectionName) {
		Section section = dao.getSectionByClassIdAndSectionName(classId,
				sectionName);
		SectionDTO sectionDTO = new SectionDTO();
		if (section != null) {
			sectionDTO.setClassName(section.getStudentClasses().getClassName());
			sectionDTO.setSectionName(section.getSectionName());
			sectionDTO.setSectionId(section.getSectionId());
		}
		return sectionDTO;
	}
}
