package ehealthcare.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.ContactBean;
import ehealthcare.Bean.PaymentBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Exception.DuplicateRecordException;
import ehealthcare.Model.AppointmentModel;
import ehealthcare.Model.ContactModel;
import ehealthcare.Model.PaymentModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class PaymentCt
 */
@WebServlet(name = "PaymentCt", urlPatterns = "/payment")
public class PaymentCt extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_PAY= "Pay";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCt() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected BaseBean populateBean(HttpServletRequest request) {
    	System.out.println("in populateBean");
		PaymentBean bean = new PaymentBean();
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCardnumber(DataUtility.getString(request.getParameter("cardnumber")));
		bean.setCardexpairy(DataUtility.getString(request.getParameter("cardexpairy")));
		bean.setCvv(DataUtility.getString(request.getParameter("cvv")));
		
		populateDTO(bean, request);
		return bean;

	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentModel model = new AppointmentModel();
		long Pid = DataUtility.getLong(request.getParameter("Pid"));
		if (Pid > 0) {
			try {
				long i = model.Confirm("Paid", Pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PaymentModel model = new PaymentModel();
	        System.out.println("in do post");
			String op = DataUtility.getString(request.getParameter("operation"));
			long id = DataUtility.getLong(request.getParameter("id"));
			PaymentBean bean = new PaymentBean();

				if (OP_PAY.equalsIgnoreCase(op)) {
					bean = (PaymentBean) populateBean(request);
					try {
						long pk = model.add(bean);
						ServletUtility.setbean(bean, request);
						ServletUtility.setSuccessMessage("Payment Done", request);
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
		return DFViewCtl.PAYMENT_VIEW;
	}

}
