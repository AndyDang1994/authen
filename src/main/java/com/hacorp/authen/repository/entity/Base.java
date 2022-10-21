package com.hacorp.authen.repository.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class Base {

	private String regisDate;
	private String regisBy;
	private String lchgDate;
	private String lchgBy;
	private String ledgerStatus;
	
	public Base() {
		super();
	}
	
	public Base(String regisDate, String regisBy, String lchgDate, String lchgBy, String ledgerStatus) {
		super();
		this.regisDate = regisDate;
		this.regisBy = regisBy;
		this.lchgDate = lchgDate;
		this.lchgBy = lchgBy;
		this.ledgerStatus = ledgerStatus;
	}



	@Column(name = "regis_dt")
	public String getRegisDate() {
		return regisDate;
	}
	public void setRegisDate(String regisDate) {
		this.regisDate = regisDate;
	}
	@Column(name = "regis_by")
	public String getRegisBy() {
		return regisBy;
	}
	public void setRegisBy(String regisBy) {
		this.regisBy = regisBy;
	}
	@Column(name = "lchg_dt")
	public String getLchgDate() {
		return lchgDate;
	}
	public void setLchgDate(String lchgDate) {
		this.lchgDate = lchgDate;
	}
	@Column(name = "lchg_by")
	public String getLchgBy() {
		return lchgBy;
	}
	public void setLchgBy(String lchgBy) {
		this.lchgBy = lchgBy;
	}
	@Column(name = "ledger_status")
	public String getLedgerStatus() {
		return ledgerStatus;
	}
	public void setLedgerStatus(String ledgerStatus) {
		this.ledgerStatus = ledgerStatus;
	}
	
}
