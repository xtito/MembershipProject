package cn.membership.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.membership.dao.UserDao;
import cn.membership.domain.Users;
import cn.membership.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
//	@Autowired
	private UserDao<Users> userDao;
	
	@Transactional(readOnly=false)
	public void saveUser(Users users) {
		this.userDao.saveEntry(users);
	}

	@Transactional(readOnly=false)
	public void deleteUser(Integer id) {
		this.userDao.deleteEntry(id);
	}

	@Transactional(readOnly=false)
	public void updateUser(Users users) {
		this.userDao.updateEntry(users);
	}

	@Transactional(readOnly=true)
	public Collection<Users> getAllUser() {
		return this.userDao.getAllEntry();
	}

	@Transactional(readOnly=true)
	public Users getUser(Integer id) {
		return this.userDao.getEntry(id);
	}
	
	@Transactional(readOnly=true)
	public Users getValidateLogin(String name, String password) {
		return this.userDao.getValidateLogin(name, password);
	}

	@Transactional(readOnly=true)
	public boolean getValidateUserName(String userName) {
		return this.userDao.getValidateUserName(userName) == null;
	}
	


	public UserDao<Users> getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao<Users> userDao) {
		this.userDao = userDao;
	}
}
