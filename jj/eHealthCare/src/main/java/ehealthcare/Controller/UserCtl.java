package ehealthcare.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Model.UserModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.DataValidator;
import ehealthcare.Utility.PropertyReader;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class UserCtl
 */
@WebServlet(name = "UserCtl" ,urlPatterns = "/user")
public class UserCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_UPDATE = "Update";
	public static final String OP_SAVE = "Save";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
   	protected boolean validate(HttpServletRequest request) {
   		System.out.println("in validation");
   		boolean pass = true;

   		if (DataValidator.isNull(request.getParameter("name"))) {
   			request.setAttribute("name", PropertyReader.getvalue("error.require", "Name"));
   			pass = false;

   		} else if (!DataValidator.isName(request.getParameter("name"))) {
   			request.setAttribute("name", PropertyReader.getvalue("error.name", "Name"));
   			pass = false;
   		}

   		if (DataValidator.isNull(request.getParameter("email"))) {
   			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email Id"));
   			pass = false;

   		} else if (!DataValidator.isEmail(request.getParameter("email"))) {
   			request.setAttribute("email", PropertyReader.getvalue("error.login", "Email Id"));
   			pass = false;
   		}

   		if (DataValidator.isNull(request.getParameter("password"))) {
   			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
   			pass = false;

   		}

   		else if (!DataValidator.isPassword(request.getParameter("password"))) {
   			request.setAttribute("password", PropertyReader.getvalue("error.password", "Password"));
   			return false;

   		}
   		if (DataValidator.isNull(request.getParameter("phoneNo"))) {
   			request.setAttribute("phoneNo", PropertyReader.getvalue("error.require", "Phone No"));
   			pass = false;

   		}

   		if ("-----Select-----".equalsIgnoreCase(request.getParameter("gender"))) {
   			request.setAttribute("gender", PropertyReader.getvalue("error.require", "Gender"));
   			pass = false;
   		}

   		return pass;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			UserBean bean = null;
			try {
				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.setbean(bean, request);
		}
		ServletUtility.forward(getView(), request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
		System.out.println("in do post");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("op:"+op);
		UserBean bean = new UserBean();
		bean = (UserBean) populateBean(request);
		if (bean.getId() > 0) {
			System.out.println("in do post2");
			long i = model.Update(bean);
			ServletUtility.setSuccessMessage("Data Updated Successfully", request);
		} else {
			try {
				long pk = model.add(bean);
				ServletUtility.setSuccessMessage("Data Add Successfully", request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		
		return DFViewCtl.USER_VIEW;
	}

}
