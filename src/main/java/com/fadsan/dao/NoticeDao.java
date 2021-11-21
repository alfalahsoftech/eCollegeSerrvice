package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Notice;

public interface NoticeDao extends DAO<Integer, Notice> {
	public List<Notice> getAllNoticeByPageno(int pageNo);
}
