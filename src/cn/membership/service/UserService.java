package cn.membership.service;

import java.util.Collection;

import cn.membership.domain.Users;


public interface UserService {
	
	/**
	 * 保存一条用户信息
	 * @param Users 接 Users 对象
	 */
	public void saveUser(Users users);
	
	/**
	 * 根据 id 删除一条用户信息
	 * @param id 接收要删除的 Users id
	 */
	public void deleteUser(Integer id);
	
	/**
	 * 更新一条用户信息
	 * @param Users 接 Users 对象
	 */
	public void updateUser(Users users);
	
	/**
	 * 查询所有用户信息
	 * @return 返回查询到的所有用户信息
	 */
	public Collection<Users> getAllUser();
	
	/**
	 * 根据 id 查询一条用户信息
	 * @param id 接收要查询的 Users id
	 * @return 返回查询到的一条用户信息
	 */
	public Users getUser(Integer id);
	
	/**
	 * 验证用户名和密码是否存在
	 * @param name 接收要验证的用户名
	 * @param password 接收要验证的密码
	 * @return 返回验证结果 true 或 false
	 */
	public Users getValidateLogin(String name, String password);
	
	/**
	 * 验证用户名是否存在
	 * @param userName 接收要验证的用户名
	 * @return 返回验证结果 true 或 false
	 */
	public boolean getValidateUserName(String userName);
	
}
