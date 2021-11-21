package com.fadsan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.DiscountDao;
import com.fadsan.model.Discount;
import com.fadsan.service.DiscountService;

@Transactional
@Service("discountService")
public class DiscountServiceImpl extends CRUDServiceImpl<Integer, Discount, DiscountDao>
implements DiscountService {
@Autowired
public DiscountServiceImpl(DiscountDao dao) {
super(dao);
}

}
