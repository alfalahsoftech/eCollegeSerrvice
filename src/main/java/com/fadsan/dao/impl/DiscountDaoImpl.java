package com.fadsan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.DiscountDao;
import com.fadsan.model.Discount;

@Transactional
@Repository("discountDao")
public class DiscountDaoImpl extends DAOImpl<Integer, Discount> implements
		DiscountDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> getDiscountAmountByMonth(Date frmDate, Date toDate) {
		return (List<Discount>) sessionFactory.getCurrentSession()
				.createCriteria(Discount.class)
				.add(Restrictions.between("cratedAt", frmDate, toDate)).list();
	}

	@Override
	public Discount getDiscountbyFeeSubId(Integer studentFeeSubmissionDetailsId) {
		return (Discount) sessionFactory
				.getCurrentSession()
				.createCriteria(Discount.class)
				.add(Restrictions.eq("studentFeeSubmissionDetails.studentFeeSubmissionDetailsId", studentFeeSubmissionDetailsId))
				.uniqueResult();
	}

}
