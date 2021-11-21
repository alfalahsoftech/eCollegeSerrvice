package com.fadsan.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.ParentsDao;
import com.fadsan.model.Parents;

@Transactional
@Repository("parentsDao")
public class ParentsDaoImpl extends DAOImpl<Integer, Parents> implements
		ParentsDao {

}
