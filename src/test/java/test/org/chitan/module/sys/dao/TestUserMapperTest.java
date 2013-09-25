package test.org.chitan.module.sys.dao;

import org.chitan.module.sys.dao.UserMapper;
import org.chitan.module.sys.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.org.chitan.AbstractJunitTest;

public class TestUserMapperTest extends AbstractJunitTest {

	@Autowired
	private UserMapper userMapper;

	public void testCount() {
		int count = userMapper.count();
		System.out.println(count);
	}

	@Test
	public void testSelectOne() {
		User user = userMapper.selectOne(1L);
		System.out.println(user.getLoginName());
	}

}
