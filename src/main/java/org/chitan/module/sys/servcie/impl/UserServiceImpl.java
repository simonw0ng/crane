package org.chitan.module.sys.servcie.impl;

import org.chitan.module.sys.dao.UserMapper;
import org.chitan.module.sys.entity.User;
import org.chitan.module.sys.servcie.IUserService;
import org.chitan.platform.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends AbstractManager<User, Long> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	public UserMapper getMapper() {
		return userMapper;
	}
}
