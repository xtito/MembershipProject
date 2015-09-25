package cn.membership.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 */
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer uid;			// 用户id
	private String userName;			// 用户名
	private String password;		// 密码
	private int status;			// 用户状态
	private Date lastModifyTime;	// 最后修改时间
	private UserType userType;		// 用户类型
	
	public Users() {
		super();
	}
	
	public Users(Integer uid, String userName, String password, int status,
			Date lastModifyTime) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.lastModifyTime = lastModifyTime;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", userName=" + userName + ", password="
				+ password + ", status=" + status + ", lastModifyTime="
				+ lastModifyTime + ", userType=" + userType + "]";
	}
	
	
}
