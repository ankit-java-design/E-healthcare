package ehealthcare.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Model.UserModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class UserListCt
 */
@WebServlet(name = "UserListCt" ,urlPatterns = "/userlist")
public class UserListCt extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SEARCH = "Search";
	public static final String OP_RESET = "Reset";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListCt() {
        super();
        // TODO Auto-generated constructor stub
    }

    
 	protected BaseBean populateBean(HttpServletRequest request) {

   		UserBean bean = new UserBean();
   		bean.setRoleid(2);
   		bean.setRolename("USER");
   		bean.setId(DataUtility.getLong(request.getParameter("id")));
   		bean.setName(DataUtility.getString(request.getParameter("name")));
   		bean.setEmail(DataUtility.getString(request.getParameter("email")));
   		bean.setPassword(DataUtility.getString(request.getParameter("password")));
   		bean.setPhoneNo(DataUtility.getString(request.getParameter("phoneNo")));
   		bean.setGender(DataUtility.getString(request.getParameter("gender")));
   		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
   		populateDTO(bean, request);
   		return bean;

   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel model = new UserModel();
		UserBean bean = null;
		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
		}

		List list = null;
		try {
			System.out.println("in do get");
			list = model.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null && list.size() == 0) {
			ServletUtility.setErrorMessage("No record found", request);
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
System.out.println("in post");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean = (UserBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(DFViewCtl.USER_LIST_CTL, request, response);
			return;
		}
		System.out.println("in post22223333");
		if (OP_SEARCH.equalsIgnoreCase(op)) {
			try {
				System.out.println("in post33333333333");
				System.out.println("name:"+bean.getName());
				list = model.search(bean);
				ServletUtility.setList(list, request);
				ServletUtility.setbean(bean, request);

			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);
		}

		
		
	}

	@Override
	protected String getView() {
		return DFViewCtl.USER_LIST_VIEW;
	}

}
