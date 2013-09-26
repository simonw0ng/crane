package test.org.chitan.module.sys.manager;

import org.chitan.module.sys.entity.User;
import org.chitan.module.sys.manager.UserManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.org.chitan.AbstractJunitTest;

public class TestUserManagerTest extends AbstractJunitTest {

	@Autowired
	private UserManager userManager;

	public void testCount() {
		int count = userManager.count();
		System.out.println(count);
	}

	@Test
	public void testSelectOne() {
		User user = userManager.selectOne(1L);
		System.out.println(user.getLoginName());
	}
}
