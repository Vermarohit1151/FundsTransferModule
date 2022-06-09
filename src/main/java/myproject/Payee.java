package myproject;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Beneficiary_Details")
public class Payee
{
	
	@Id
	@Column(name = "Payee_Id")
	@GeneratedValue
	private int payeeId;
	
	@Column(name = "Payee_Name",length=20)
	private String payeeName;
	
	@Column(name = "Account_Number")
	private double accountNumber;
	
	@Column(name= "IFSC",length=11)
	private String ifsc;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Transactions> txn;

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
}
