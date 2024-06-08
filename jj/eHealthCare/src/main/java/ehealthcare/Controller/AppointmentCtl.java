package ehealthcare.Controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ehealthcare.Bean.AppointmentBean;
import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Exception.DuplicateRecordException;
import ehealthcare.Model.AppointmentModel;
import ehealthcare.Model.DoctorModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

@WebServlet(name = "AppointmentCtl", urlPatterns = "/appointment")
public class AppointmentCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SAVE = "Save";
	public static final String OP_RESET = "Reset";

    public AppointmentCtl() {
        super();
    }
    
    
    
    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		AppointmentBean bean = new AppointmentBean();
		System.out.println("in populateBean");
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		bean.setPatientname(existBean.getName());
		bean.setStatus("booked");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setDoctorName(DataUtility.getString(request.getParameter("doctor")));
		bean.setDisease(DataUtility.getString(request.getParameter("disease")));
		bean.setAppointmentdate(DataUtility.getDate(request.getParameter("date")));
		bean.setAppointmenttime(LocalTime.parse(request.getParameter("time")));
		bean.setAppointmentdescription(DataUtility.getString(request.getParameter("description")));
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorModel dmodel = new DoctorModel();
		
		AppointmentBean bean = new AppointmentBean();
		
		long Bid = DataUtility.getLong(request.getParameter("Bid"));
		String name = DataUtility.getString(request.getParameter("name"));
		if (Bid > 0) {
			try {
				dmodel.Booked("Booked", Bid);
				bean.setDoctor(name);
				ServletUtility.setbean(bean, request);
				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentModel model = new AppointmentModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		AppointmentBean bean = new AppointmentBean();
		bean = (AppointmentBean) populateBean(request);
		if (OP_SAVE.equalsIgnoreCase(op)) {
			bean = (AppointmentBean) populateBean(request);
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Appointment Successfully Book", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setbean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(), request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);
		}
	}

	@Override
	protected String getView() {
		return DFViewCtl.APPOINTMENT_VIEW;
	}

}
