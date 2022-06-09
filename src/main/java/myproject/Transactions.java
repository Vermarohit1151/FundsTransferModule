package myproject;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Transactions")
public class Transactions {
	
	@Id
	@GeneratedValue
	@Column(name = "Reference_ID",length=10)
	private String refID;
	
	@Column(name = "Transaction_Mode",length=4)
	private String modeOfPayment;
	
	@Column(name = "Amount")
	private double Amount;
	
	@Column(name = "Date_of_Payment")
	private Date dateOfPayment;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Payee_ID")
	private Payee payee;

	public String getRefID() {
		return refID;
	}

	public void setRefID(String refID) {
		this.refID = refID;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Payee getPayee() {
		return payee;
	}

	public void setPayee(Payee payee) {
		this.payee = payee;
	}
	
	
	
}
