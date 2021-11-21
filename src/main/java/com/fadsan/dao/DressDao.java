package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Dress;

public interface DressDao extends DAO<Integer, Dress> {

	List<Dress> findfirstdress();

	List<Dress> getDressNameslist();

	Dress getFirstDress();

	List<Dress> getDressAllDetails(String dressName);

	List<Dress> getDressNamelist();

	List<Dress> getCategoryList(String name);

	List<Dress> getSizeList(String category,String name);

	List<String> getDistinctCateegory(String dressName);

	Dress findprice(String dressName, String category, String size);

}
