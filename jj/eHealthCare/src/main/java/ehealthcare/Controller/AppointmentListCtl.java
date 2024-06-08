package ehealthcare.Controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ehealthcare.Bean.AppointmentBean;
import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Model.AppointmentModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class AppointmentListCtl
 */
@WebServlet(name = "AppointmentListCtl", urlPatterns = "/appointmentlist")
public class AppointmentListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SEARCH = "search";
	public static final String OP_RESET = "Reset";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentListCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

   	protected BaseBean populateBean(HttpServletRequest request) {
   		AppointmentBean bean = new AppointmentBean();
   		try {
			
		
   		bean.setId(DataUtility.getLong(request.getParameter("id")));
   		System.out.println("in populateBean"+bean.getPatientname());
   		bean.setDoctorName(DataUtility.getString(request.getParameter("doctor")));
   		bean.setPatientname(DataUtility.getString(request.getParameter("patient")));
   		bean.setDisease(DataUtility.getString(request.getParameter("disease")));
   		bean.setAppointmentdate(DataUtility.getDate(request.getParameter("date")));
   		System.out.println("in populateBean");
		bean.setAppointmenttime(LocalTime.parse(request.getParameter("time")));
   		System.out.println("in populateBean"+bean.getAppointmentdescription());
   		bean.setAppointmentdescription(DataUtility.getString(request.getParameter("description")));
   		populateDTO(bean, request);
   		
   		} catch (Exception e) {
			e.printStackTrace();
		}
   		return bean;
   	}

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentModel model = new AppointmentModel();
		AppointmentBean bean = null;
		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
		}
		long Cid = DataUtility.getLong(request.getParameter("Cid"));
		if (Cid > 0) {
			try {
				long i = model.Confirm("Confirm", Cid);
				ServletUtility.setSuccessMessage("Appointment Confirm !!", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long Rid = DataUtility.getLong(request.getParameter("Rid"));
		if (Rid > 0) {
			try {
				long i = model.cancle("Cancle", Rid);
				ServletUtility.setErrorMessage("Appointment Cancle !!", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 List list = null;
	        HttpSession session = request.getSession(false);
	    	UserBean bean2 = (UserBean) session.getAttribute("user");
	    	long roleid = bean2.getRoleid();
	    	if (roleid==2) {
	    		   try {
	    			     list =	model.Showlist(bean2.getId());
	    			     ServletUtility.setList(list, request);
	    			     ServletUtility.forward(getView(), request, response);
	    			} catch (Exception e) {
	    			}
			}else{
				 try {
				     list =	model.list();
				     ServletUtility.setList(list, request);
				     
				} catch (Exception e) {
				}
			        ServletUtility.forward(getView(), request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
          System.out.println("in post");
          try {  
          AppointmentModel model = new AppointmentModel();
          AppointmentBean bean = new AppointmentBean();
		bean = (AppointmentBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(DFViewCtl.APPOINTMENT_LIST_CTL, request, response);
			return;
		}
		System.out.println("in post22223333");
		if (OP_SEARCH.equalsIgnoreCase(op)) {
			
				System.out.println("in post33333333333");
				list = model.search(bean);
				ServletUtility.setList(list, request);
				ServletUtility.setbean(bean, request);
		}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);
		

		
	}

	@Override
	protected String getView() {
		return DFViewCtl.APPOINTMENT_LIST_VIEW;
	}

}
