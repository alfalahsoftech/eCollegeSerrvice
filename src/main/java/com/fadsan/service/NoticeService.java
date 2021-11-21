package com.fadsan.service;

import java.text.ParseException;
import java.util.List;

import com.fadsan.model.Notice;
import com.fadsan.models.dto.NoticeDTO;

public interface NoticeService extends CRUDService<Integer, Notice> {
	NoticeDTO CreateNotice(NoticeDTO noticeDTO) throws ParseException;

	List<NoticeDTO> ShowAllNotice();

	NoticeDTO EditNotice(int id) throws ParseException;

	List<NoticeDTO> getAllNoticeByPageno(int pageNo);

	void UpdateNotice(NoticeDTO noticeDTO) throws ParseException;

	NoticeDTO viewpdfnotice(int id);
}
