package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Section;

public interface SectionDao extends DAO<Integer, Section>{

	List<Section> getSectionListByClassId(int classId);
	
	Section getSectionByClassIdAndSectionName(int classId,String sectionName);

}
