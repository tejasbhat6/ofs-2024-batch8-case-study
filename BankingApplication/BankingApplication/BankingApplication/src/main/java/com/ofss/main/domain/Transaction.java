package com.ofss.main.domain;

public class Transaction {

    private int id;
    private int from_acc;
    private int to_acc;
    private double amount;
    private String status;
    private String remarks;
    private String created_at;
    private String completed_at;
    private String transfer_type;
    private String transaction_type;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFrom_acc() {
        return from_acc;
    }
    public void setFrom_acc(int from_acc) {
        this.from_acc = from_acc;
    }
    public int getTo_acc() {
        return to_acc;
    }
    public void setTo_acc(int to_acc) {
        this.to_acc = to_acc;
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
    
}
