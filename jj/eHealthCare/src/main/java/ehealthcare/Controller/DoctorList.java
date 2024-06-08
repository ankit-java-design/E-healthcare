package ehealthcare.Controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.DoctoreBean;
import ehealthcare.Model.DoctorModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

@WebServlet(name = "DoctorList", urlPatterns = "/doctorview")
public class DoctorList extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SEARCH = "search";
	public static final String OP_RESET = "Reset";
    public DoctorList() {
        super();
    }

    protected BaseBean populateBean(HttpServletRequest request) {
		DoctoreBean bean = new DoctoreBean();
		try {
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
		populateDTO(bean, request);
		} catch (Exception e) {
e.printStackTrace();
		}
		return bean;
	}
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorModel model = new DoctorModel();
		DoctoreBean bean = null;
		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
		}

		List list = null;
		try {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		DoctorModel model = new DoctorModel();
		DoctoreBean bean = new DoctoreBean();
		bean = (DoctoreBean) populateBean(request);
		
		List list = null;
		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(DFViewCtl.DOCTOR_VIEW_CTL, request, response);
			return;
		}
		if (OP_SEARCH.equalsIgnoreCase(op)) {
			try {
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
		return DFViewCtl.DOCTOR_LIST;
	}

}
