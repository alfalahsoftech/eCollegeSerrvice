package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.LastDate;

public interface LastDateDao extends DAO<Integer, LastDate> {

	LastDate getLastDatebyMonth(int monthId, int sessionId);

	LastDate getLastDatebyMonth(int monthId);

	List<LastDate> getLastDatesBySessionId(Integer sessionId);

}
