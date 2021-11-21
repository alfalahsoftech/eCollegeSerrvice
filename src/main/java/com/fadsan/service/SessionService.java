package com.fadsan.service;

import java.util.List;

import com.fadsan.model.Session;
import com.fadsan.models.dto.SessionDTO;

public interface SessionService extends CRUDService<Integer, Session> {

	SessionDTO findCurrent();

	List<SessionDTO> findAllsession();

	SessionDTO getSessionById(int sessionId);

	void setActivebyId(int sessionId);

	void changeCurrentSession(Session session1);

	List<SessionDTO> findAllActiveSession();

	SessionDTO getSessionByName(String sessionName);

	List<SessionDTO> getToSession(int sessionId);

	List<SessionDTO> findAllprevioussession();

}
