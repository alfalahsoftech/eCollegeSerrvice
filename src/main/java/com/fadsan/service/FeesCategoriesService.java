package com.fadsan.service;

import java.util.List;

import com.fadsan.model.FeesCategories;
import com.fadsan.models.dto.FeesCategoriesDTO;

public interface FeesCategoriesService extends CRUDService<Integer, FeesCategories>{

	public FeesCategoriesDTO getFeeCategoriesDTOById(int feeCategoryId);

	public void createFeeCategories(FeesCategoriesDTO feeCategoryDTO);

	public void updateFeeCategories(FeesCategoriesDTO feeCategoryDTO);

	public String verifyduplicatename(String name);
	
	public List<FeesCategoriesDTO> getFeesCategories(String studentAdmissionNo,int recieptNo);

}
