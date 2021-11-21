package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.AllotDress;

public interface AllotDressDao extends DAO<Integer, AllotDress> {

	List<AllotDress> finddetailsbyId(Integer productPurchaseId);

}
