package org.chitan.module.sys.manager;

import org.chitan.module.sys.dao.UserMapper;
import org.chitan.module.sys.entity.User;
import org.chitan.platform.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager extends AbstractManager<User, Long> {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	public UserMapper getMapper() {
		return userMapper;
	}

}
