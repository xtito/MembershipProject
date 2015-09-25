package cn.membership.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户类型实体类
 */
public class UserType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private String userTypeName;
	private Set<Users> users = new HashSet<Users>();
	
	public UserType() {
		super();
	}
	
	public UserType(Integer tid, String userTypeName) {
		super();
		this.tid = tid;
		this.userTypeName = userTypeName;
	}
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserType [tid=" + tid + ", userTypeName=" + userTypeName + "]";
	}
	
}
