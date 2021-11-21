package com.fadsan.service;

import java.util.List;

import com.fadsan.model.User;
import com.fadsan.models.dto.ChangePasswordDTO;
import com.fadsan.models.dto.UserDTO;

public interface UserService extends CRUDService<Integer, User> {
	public User getUserByUserName(String userName);

	public String checkUserByUserName(String userName);

	String crateUser(UserDTO dto);

	List<UserDTO> searchUsertByName(String userName);

	void disableUserById(int id);

	UserDTO getById(int id);
	
	User getByUserId(int id);

	void updateUserById(UserDTO dto);

	public User checkUserByUserName(String userName, String password,
			int retryCount);

	public User checkUserByUserName(String userName, String password);

	void changeAdminPassword(ChangePasswordDTO dto, User user);

	User getUserByPassword(String password);
}
