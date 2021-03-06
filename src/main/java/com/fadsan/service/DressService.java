package com.fadsan.service;

import java.util.List;

import com.fadsan.model.Dress;
import com.fadsan.models.dto.DressDTO;

public interface DressService extends CRUDService<Integer, Dress> {

	List<DressDTO> findfirstdressName();

	List<DressDTO> getDressNames();

	DressDTO getDressById(int dressId);

	void updatePrices(int dressId,int newprice);

	DressDTO getCurrentdressname();

	List<DressDTO> getDressDetails(int dressId);

	List<DressDTO> getDressName();

	List<DressDTO> getDressCategory(int dressId);

	List<DressDTO> getDressSize(int dressId);

	DressDTO getPrice(int dressId);

	List<DressDTO> getDressNameandCategory();

	int getDressIdforcategory(String name, String category);

	DressDTO getPriceforsize(int dressId, String size);



}
