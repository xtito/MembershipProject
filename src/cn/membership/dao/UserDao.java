package cn.membership.dao;

public interface UserDao<T> extends BaseDao<T> {
	
	/**
	 * 验证用户名和密码
	 * @param name 接收要验证的用户名
	 * @param password 接收要验证的密码
	 * @return 返回验证结果
	 */
	public T getValidateLogin(String name, String password);
	
	/**
	 * 验证用户名是否存在
	 * @param name 接收要验证的用户名
	 * @return 返回验证结果
	 */
	public T getValidateUserName(String name);
	
}
