package cn.membership.dao;

import java.util.Collection;


public interface BaseDao<T> {
	
	/**
	 * 保存一条数据
	 * @param t 接收要保存的实体类对象
	 */
	public void saveEntry(T t);
	
	/**
	 * 根据 id 删除一条数据
	 * @param id 接收要删除的实体类对象 id
	 */
	public void deleteEntry(Integer id);
	
	/**
	 * 更新一条数据
	 * @param t 接收要更新的实体类对象
	 */
	public void updateEntry(T t);
	
	/**
	 * 查询所有数据
	 * @return 返回查询到的所有数据
	 */
	public Collection<T> getAllEntry();
	
	/**
	 * 根据 id 查询一条数据
	 * @param id 接收要查询的实体类对象 id
	 * @return 返回到的一条数据
	 */
	public T getEntry(Integer id);
	
}
