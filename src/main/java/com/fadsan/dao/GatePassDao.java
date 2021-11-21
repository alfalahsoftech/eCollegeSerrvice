package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.GatePass;

public interface GatePassDao extends DAO<Integer, GatePass>{

	List<GatePass> findPreviousDetailsById(String id);

	List<GatePass> findDateWiseDetails(Date leavingDate);

}
