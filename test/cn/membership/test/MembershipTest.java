package cn.membership.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.membership.domain.Users;
import cn.membership.service.UserService;

public class MembershipTest {
	
	private ApplicationContext context;
	
	{
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	
	@Test
	public void testAdd() {
		
		UserService userService = (UserService) context.getBean("userService");
//		Users users = new Users(-1, "赵东飞", "zdf123456", 0, new Date());
//		userService.saveUser(users);
		Users users = userService.getValidateLogin("张三", "zs123456");
		System.out.println(users.toString());
		
	}
	
}
