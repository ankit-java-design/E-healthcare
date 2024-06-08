package ehealthcare.Controller;

public interface DFViewCtl {

	public String APP_CONTEXT = "/eHealthCare";
	public String PAGE_FOLDER = "/jsp";
	
	
	//Controller------------------------------
		public String WELCOME_CTL = APP_CONTEXT + "/welcome";
		public String LOGIN_CTL = APP_CONTEXT + "/login";
		public String REGISTRAION_CTL = APP_CONTEXT + "/registration";
		public String USER_CTL = APP_CONTEXT + "/user";
		public String USER_LIST_CTL = APP_CONTEXT + "/userlist";
		public String DOCTOR_CTL = APP_CONTEXT + "/doctor";
		public String DOCTOR_LIST_CTL = APP_CONTEXT + "/doctorlist";
		public String APPOINTMENT_CTL = APP_CONTEXT + "/appointment";
		public String APPOINTMENT_LIST_CTL = APP_CONTEXT + "/appointmentlist";
		public String CONTACT_CTL = APP_CONTEXT +  "/contact";
		public String DOCTOR_VIEW_CTL = APP_CONTEXT + "/doctorview";
		public String ABOUT_CTL = APP_CONTEXT +  "/about";
		public String PAYMENT_CTL = APP_CONTEXT +  "/payment";
		public String PAYMENT_LIST_CTL = APP_CONTEXT +  "/paymentlist";

		
		//View-------------------------------------
		public String WELCOME_VIEW = PAGE_FOLDER + "/WelcomeView.jsp";
		public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
		public String REGISTRAION_VIEW = PAGE_FOLDER + "/Registration.jsp";
		public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
		public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
		public String DOCTOR_VIEW = PAGE_FOLDER + "/DoctoreView.jsp";
		public String DOCTOR_LIST_VIEW = PAGE_FOLDER + "/DoctorListView.jsp";
		public String APPOINTMENT_VIEW = PAGE_FOLDER + "/AppointmentView.jsp";
		public String APPOINTMENT_LIST_VIEW = PAGE_FOLDER + "/AppointmentListView.jsp";
		public String CONTACT_VIEW = PAGE_FOLDER + "/ContactView.jsp";
		public String DOCTOR_LIST = PAGE_FOLDER + "/DoctorList.jsp";
		public String ABOUT_VIEW = PAGE_FOLDER + "/About.jsp";
		public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp";
		public String PAYMENT_LIST_VIEW = PAGE_FOLDER + "/PaymentListView.jsp";

}
