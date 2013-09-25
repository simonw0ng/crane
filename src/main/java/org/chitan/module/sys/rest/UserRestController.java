package org.chitan.module.sys.rest;

import org.chitan.module.sys.entity.User;
import org.chitan.module.sys.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User的Restful API的Controller.
 * 
 * @author CHENLEI
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserRestController {

	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserManager userManager;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User selectOne() {
		return userManager.selectOne(1L);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> selectOne(@PathVariable("id") Long id) {
		User user = userManager.selectOne(id);
		if (user == null) {
			logger.warn("user with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}
}
