package cn.membership.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.membership.domain.Users;
import cn.membership.service.UserService;

@Controller()
@Scope("prototype")
public class UserAction extends BaseAction<Users> {

	private static final long serialVersionUID = 1L;
	private String loginName;
	private String loginPwd;
	private InputStream inputStream;
	// 用户Ajax返回数据
	private Object result;
	@Autowired
	private UserService userService;
	
	public String login() {
		Users user = this.userService.getValidateLogin(loginName, loginPwd);
		if (!this.userService.getValidateUserName(loginName)) {
			// 如果用户名存在
			if (user != null && user.getStatus() != 0) {
				this.result = "登录成功";
			} else if (user != null && user.getStatus() == 0) {
				// 如果用户名和密码正确，但用户状态为冻结，则返回3
				this.result = "用户冻结";
			} else {
				// 如果用户名和密码错误，则返回4
				this.result = "密码错误";
			}
		} else {
			// 用户名不存在
			this.result = "用户不存在";
		}
		return jsonResult;
	}
	
	public String validateUserName() {
		if (this.userService.getValidateUserName(this.getModel().getUserName())) {
			try {
				// 如果为NULL，则用户名不存在
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return ajax;
	}
	
	public String list() {
		
		return listAction;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
