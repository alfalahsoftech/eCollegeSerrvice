package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.VisitorsDetails;

public interface VisitorsDetailsDao extends DAO<Integer, VisitorsDetails> {
	public List<VisitorsDetails> getVisitorsDetailsByDate(Date date);
	public List<VisitorsDetails> getVisitorsDetailsByName(String visitorName);

}
