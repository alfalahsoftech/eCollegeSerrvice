package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Session;

public interface SessionDao extends DAO<Integer, Session>{

	Session findCurrentSession();

	List<Session> findallsessions();
	
	Session getSessionByName(String sessionName);

}
