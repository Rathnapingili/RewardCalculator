package web.api.assessment.model;

public class Transactions {
	
	/**
	 * 
	 */
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param custID
	 * @param dlrSpent
	 * @param month
	 */
	public Transactions(String custID, Integer dlrSpent, String month) {
		super();
		this.custID = custID;
		this.dlrSpent = dlrSpent;
		this.month = month;
	}
	/**
	 * @return the custID
	 */
	public String getCustID() {
		return custID;
	}
	/**
	 * @param custID the custID to set
	 */
	public void setCustID(String custID) {
		this.custID = custID;
	}
	/**
	 * @return the dlrSpent
	 */
	public Integer getDlrSpent() {
		return dlrSpent;
	}
	/**
	 * @param dlrSpent the dlrSpent to set
	 */
	public void setDlrSpent(Integer dlrSpent) {
		this.dlrSpent = dlrSpent;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	String custID;
	Integer dlrSpent;
	String month;

}
