package action;

/**
 * Clase usada como referencia para implementar una comunicación con el Navegador y
 * el servidor usando AJAX
 * 
 * Eliminar esta clase cuando ya no se necesite
 */

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pojo.EmpBean;

public class ReportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	EmpBean bean = null;
	List<EmpBean> beanList = null;

	@Override
	public String execute() throws Exception {

		beanList = new ArrayList<EmpBean>();

		bean = new EmpBean();
		bean.setUname("Roberto");
		bean.setUemail("robert@gmail.com");
		bean.setUpass("hola123");
		bean.setUdeg("Some Stuff");
		beanList.add(bean);
		
		bean = new EmpBean();
		bean.setUname("David");
		bean.setUemail("davis@gmail.com");
		bean.setUpass("hola123");
		bean.setUdeg("Some Stuff");
		beanList.add(bean);

		return "REPORT";
	}

	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
	}
}