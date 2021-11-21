package com.fadsan.dao;

import com.fadsan.model.Fine;

public interface FineDao extends DAO<Integer, Fine> {
	public Fine getFineByName(String Name, int sessionId);
}
