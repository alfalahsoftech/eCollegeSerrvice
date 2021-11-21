package com.fadsan.dao;

import com.fadsan.model.FeesCategories;

public interface FeesCategoriesDao extends DAO<Integer, FeesCategories> {

	FeesCategories getverifiedname(String name);

}
