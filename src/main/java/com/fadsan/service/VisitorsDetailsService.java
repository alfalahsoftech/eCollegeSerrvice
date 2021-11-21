package com.fadsan.service;

import java.util.List;
import java.util.Map;

import com.fadsan.model.VisitorsDetails;

public interface VisitorsDetailsService extends
		CRUDService<Integer, VisitorsDetails> {
	public Map<String, Object> getVisitorsDetailsByDate(String Date) throws Exception;
	public void addVisitorsDetails(VisitorsDetails visitorsDetails);
	List<VisitorsDetails> getVisitorsDetailsByName(String visitorName);

}
