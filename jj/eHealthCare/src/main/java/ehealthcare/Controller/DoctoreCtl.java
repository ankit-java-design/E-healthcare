package ehealthcare.Controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.DoctoreBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Exception.DuplicateRecordException;
import ehealthcare.Model.DoctorModel;
import ehealthcare.Model.UserModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.DataValidator;
import ehealthcare.Utility.PropertyReader;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class DoctoreCtl
 */
@WebServlet(name = "DoctoreCtl", urlPatterns = "/doctor")
public class DoctoreCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SAVE = "Save";
	public static final String OP_RESET = "Reset";
	public static final String OP_UPDATE = "Update";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctoreCtl() {
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

		} 

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email Id"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getvalue("error.require", "Location"));
			pass = false;

		}
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getvalue("error.require", "Gender"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("category"))) {
			request.setAttribute("category", PropertyReader.getvalue("error.require", "Category"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("fees"))) {
			request.setAttribute("fees", PropertyReader.getvalue("error.require", "Fees"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("experience"))) {
			request.setAttribute("experience", PropertyReader.getvalue("error.require", "Experience"));
			pass = false;

		}
		return pass;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorModel model = new DoctorModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			DoctoreBean bean = null;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorModel model = new DoctorModel();
		System.out.println("in do post");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("op:" + op);
		DoctoreBean bean = new DoctoreBean();
		bean = (DoctoreBean) populateBean(request);
		if (bean.getId() > 0) {
			System.out.println("in do post2");
			long i = model.Update(bean);
			ServletUtility.setSuccessMessage("Data Updated Successfully", request);
		} else {
			try {
				long pk = model.add(bean);
				ServletUtility.setSuccessMessage("Data Add Successfully", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return DFViewCtl.DOCTOR_VIEW;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		DoctoreBean bean = new DoctoreBean();
		System.out.println("in populateBean");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));
		bean.setFrom(LocalTime.parse(request.getParameter("from")));
		bean.setTo(LocalTime.parse(request.getParameter("to")));
		bean.setFees(DataUtility.getString(request.getParameter("fees")));
		bean.setExperience(DataUtility.getString(request.getParameter("experience")));
		bean.setStatus("status");
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		populateDTO(bean, request);
		return bean;
	}

}
