package com.fadsan.service;

import java.util.List;

import com.fadsan.model.AllotDress;
import com.fadsan.models.dto.AllotDressDTO;
import com.fadsan.models.dto.BookPurchaseDTO;
import com.fadsan.models.dto.DressDTO;
import com.fadsan.models.dto.UniformPurchaseDTO;

public interface AllotDressService extends CRUDService<Integer, AllotDress> {

	void savedressdata(int dressId, int quantity);

	List<AllotDressDTO> getAllDetails();

	void removealloted(int allotedId);

	void savedress(DressDTO dressDTO);

	String getStudentData();

	void saveUniform(UniformPurchaseDTO uniformPurchaseDTO);

	List<AllotDressDTO> getAllSoldUniformDetails();

	void emptytable();

	void savePurchasedUniforms(UniformPurchaseDTO uniformPurchaseDTO);

	List<AllotDressDTO>  getPurchaseDetails();

	Integer getTotalAmount();

	AllotDressDTO getPurchaseDetailsbyId(int allotDressId);

	void updatepurchases(AllotDressDTO allotDressDTO);

	void savePurchasedBooks(BookPurchaseDTO bookPurchaseDTO);

	List<AllotDressDTO> getBookPurchaseDetails();

	AllotDressDTO getBookPurchaseDetailsbyId(int allotDressId);

	void updatebookpurchases(AllotDressDTO allotDressDTO);

;

	

	

}
