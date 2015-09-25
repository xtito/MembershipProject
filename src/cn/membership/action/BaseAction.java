package cn.membership.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = 1L;
	private static final String LISTACTION = "listAction";
	private static final String ACTION2ACTION = "action2action";
	private static final String ADDUI = "addUI";
	private static final String UPDATEUI = "updateUI";
	private static final String AJAX = "ajax";
	private static final String JSONRESULT = "jsonResult";
	public String listAction = LISTACTION;
	public String action2action = ACTION2ACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	public String ajax = AJAX;
	public String jsonResult = JSONRESULT;
	private Class<T> classt;
	private T t;
	
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.classt = (Class<T>) type.getActualTypeArguments()[0];
			this.t = this.classt.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {		
		return this.t;
	}

}
