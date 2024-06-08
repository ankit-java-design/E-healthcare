package ehealthcare.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ehealthcare.Bean.BaseBean;
import ehealthcare.Bean.PaymentBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Model.PaymentModel;
import ehealthcare.Utility.DataUtility;
import ehealthcare.Utility.ServletUtility;

/**
 * Servlet implementation class PaymentListCtl
 */
@WebServlet(name = "PaymentListCtl", urlPatterns = "/paymentlist")
public class PaymentListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentListCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		System.out.println("in populateBean");
		PaymentBean bean = new PaymentBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCardnumber(DataUtility.getString(request.getParameter("cardnumber")));
		bean.setCardexpairy(DataUtility.getString(request.getParameter("cardexpairy")));
		bean.setCvv(DataUtility.getString(request.getParameter("cvv")));
		populateDTO(bean, request);
		return bean;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();
		List list = null;
		HttpSession session = request.getSession(false);
		UserBean bean2 = (UserBean) session.getAttribute("user");
		long roleid = bean2.getRoleid();
		if (roleid == 2) {
			try {
				list = model.Showlist(bean2.getId());
				ServletUtility.setList(list, request);

			} catch (Exception e) {
			}
		} else {
			try {
				list = model.list();
				ServletUtility.setList(list, request);

			} catch (Exception e) {

			}

			long id = DataUtility.getLong(request.getParameter("id"));
			if (id > 0) {
				model.delete(id);
				ServletUtility.setSuccessMessage("FIR Deleted Successfully", request);
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected String getView() {
		return DFViewCtl.PAYMENT_LIST_VIEW;
	}

}
