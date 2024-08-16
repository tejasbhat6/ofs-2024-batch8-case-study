package com.ofss.main.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="Transaction")

public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="transaction_id")
    private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payee_account_id")
    private Account payeeAccount;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payer_account_id")
    private Account payerAccount;
	@Column(name ="transaction_amount")
    private double amount;
	@Column(name ="transaction_status")
    private String status;
	@Column(name ="transaction_remarks")
    private String remarks;
	@Column(name ="transaction_created_at")
    private String created_at;
	@Column(name ="transaction_completed_at")
    private String completed_at;
	@Column(name ="transfer_type")
    private String transfer_type;
	@Column(name ="transaction_type")
    private String transaction_type;
	
	
	
	public Transaction() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Account getPayeeAccount() {
		return payeeAccount;
	}



	public void setPayeeAccount(Account payeeAccount) {
		this.payeeAccount = payeeAccount;
	}



	public Account getPayerAccount() {
		return payerAccount;
	}



	public void setPayerAccount(Account payerAccount) {
		this.payerAccount = payerAccount;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getCreated_at() {
		return created_at;
	}



	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}



	public String getCompleted_at() {
		return completed_at;
	}



	public void setCompleted_at(String completed_at) {
		this.completed_at = completed_at;
	}



	public String getTransfer_type() {
		return transfer_type;
	}



	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}



	public String getTransaction_type() {
		return transaction_type;
	}



	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}



	public Transaction(int id, Account payeeAccount, Account payerAccount, double amount, String status, String remarks,
			String created_at, String completed_at, String transfer_type, String transaction_type) {
		super();
		this.id = id;
		this.payeeAccount = payeeAccount;
		this.payerAccount = payerAccount;
		this.amount = amount;
		this.status = status;
		this.remarks = remarks;
		this.created_at = created_at;
		this.completed_at = completed_at;
		this.transfer_type = transfer_type;
		this.transaction_type = transaction_type;
	}



	@Override
	public String toString() {
		return "Transaction [id=" + id + ", payeeAccount=" + payeeAccount + ", payerAccount=" + payerAccount
				+ ", amount=" + amount + ", status=" + status + ", remarks=" + remarks + ", created_at=" + created_at
				+ ", completed_at=" + completed_at + ", transfer_type=" + transfer_type + ", transaction_type="
				+ transaction_type + "]";
	}
	
    
    
}
