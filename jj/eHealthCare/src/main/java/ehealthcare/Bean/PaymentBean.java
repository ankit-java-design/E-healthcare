package ehealthcare.Bean;

public class PaymentBean extends BaseBean{

	private String cardnumber;
	private String cardexpairy;
	private String cvv;
	private long userid;
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getCardexpairy() {
		return cardexpairy;
	}
	public void setCardexpairy(String cardexpairy) {
		this.cardexpairy = cardexpairy;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
}
