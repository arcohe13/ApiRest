package com.systarco.pup.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table (name= "TransTarifaComis")
public class TransTarifaComis {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtrans")
	private Long idtrans;
	@Column(name="codtrans")
	private Long codtrans;
	@Column(name="descritrans")
	private String descritrans;
	@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="fchcrea") 
	private Date fchcrea;
    @Column(name="codcarnetrespb")
	private int codcarnetrespb;
	
    public Long getIdtrans() {
		return idtrans;
	}
	public void setIdtrans(Long idtrans) {
		this.idtrans = idtrans;
	}
	public Long getCodtrans() {
		return codtrans;
	}
	public void setCodtrans(Long codtrans) {
		this.codtrans = codtrans;
	}
	public String getDescritrans() {
		return descritrans;
	}
	public void setDescritrans(String descritrans) {
		this.descritrans = descritrans;
	}
	public Date getFchcrea() {
		return fchcrea;
	}
	public void setFchcrea(Date fchcrea) {
		this.fchcrea = fchcrea;
	}
	public int getCodcarnetrespb() {
		return codcarnetrespb;
	}
	public void setCodcarnetrespb(int codcarnetrespb) {
		this.codcarnetrespb = codcarnetrespb;
	}
}
