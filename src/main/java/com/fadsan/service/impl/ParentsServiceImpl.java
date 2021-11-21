package com.fadsan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.util.RandomPasswordUtil;
import com.fadsan.dao.LoginRoleDao;
import com.fadsan.dao.ParentsDao;
import com.fadsan.dao.StudentsAdmissionDao;
import com.fadsan.dao.UserDao;
import com.fadsan.dao.UserRoleDao;
import com.fadsan.model.LoginRole;
import com.fadsan.model.Parents;
import com.fadsan.model.Students;
import com.fadsan.model.User;
import com.fadsan.model.UserRole;
import com.fadsan.model.UserRolePrimaryKey;
import com.fadsan.model.util.EmailUtility;
import com.fadsan.model.util.PasswordEncoder;
import com.fadsan.models.dto.ParentsDTO;
import com.fadsan.service.ParentsService;

@Transactional
@Service("parentsService")
public class ParentsServiceImpl extends
		CRUDServiceImpl<Integer, Parents, ParentsDao> implements ParentsService {

	@Autowired
	public ParentsServiceImpl(ParentsDao dao) {
		super(dao);
	}

	@Autowired
	LoginRoleDao roleDao;
	@Autowired
	UserDao userDao;
	@Autowired
	UserRoleDao userRoleDao;
	@Autowired
	StudentsAdmissionDao studentsAdmissionDao;

	@Transactional
	public String parentsRegistration(ParentsDTO dto) throws Exception {

		if (studentsAdmissionDao.get(dto.getStudentAdmissionNumber())
				.getParents() == null) {
			User user = new User();
			String userName = dto.getParentsName().substring(0, 3)
					+ RandomPasswordUtil.getRandomString();
			String password = RandomPasswordUtil.getRandomString();
			user.setEnabled(true);
			user.setPassword(PasswordEncoder.getEcodedPassword(password));
			user.setUsername(userName);
			LoginRole role = roleDao.getUserRoleByName("ROLE_PARENTS");
			UserRolePrimaryKey key = new UserRolePrimaryKey();
			key.setRole(role);
			key.setUser(userDao.create(user));
			UserRole userRole = new UserRole();
			userRole.setUserRolePrimaryKey(key);
			userRoleDao.create(userRole);

			Parents parents = new Parents();
			parents.setParentsEmail(dto.getParentsEmail());
			parents.setParentsMobile(dto.getParentsMobile());
			parents.setParentsName(dto.getParentsName());
			parents.setStudents(studentsAdmissionDao.getActive(Students.class,
					dto.getStudentAdmissionNumber()));
			parents.setUser(userDao.create(user));
			dao.create(parents);
			String msg = "You Are Successsfully Registered. Your Login Details is given below:<br>Username:"
					+ " " + userName + "<br>Password:" + " " + password;
			EmailUtility.sendEmailWithAttachment(dto.getParentsEmail(),
					"Parents Login Details", msg);
			return "success";
		} else {
			return "unsuccess";
		}
	}

}
