package cn.membership.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.membership.dao.UserDao;
import cn.membership.domain.Users;

@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao<Users> {

	public Users getValidateLogin(String name, String password) {
		String hql = "from Users where name = ? and password = ?";
		List<Users> usersList = this.getSession().createQuery(hql)
				.setString(0, name).setString(1, password).list();
		Users user = null;
		for (Users users:usersList) {
			user = users;
		}
		return user;
	}

	public Users getValidateUserName(String name) {
		String hql = "from Users where name = ?";
		Query query = this.getSession().createQuery(hql).setString(0, name);
		Users users = (Users) query.uniqueResult();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
	
}
