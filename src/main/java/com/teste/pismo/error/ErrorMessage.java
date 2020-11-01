package com.teste.pismo.error;

import java.util.Date;

public class ErrorMessage {
	
	private String message;
	private Date dateTimeErro;
	
	public ErrorMessage() {
	}
	
	public ErrorMessage(String message, Date dateTimeError) {
		this.message = message;
		this.dateTimeErro = dateTimeError;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDateTimeErro() {
		return dateTimeErro;
	}
	
	public void setDateTimeErro(Date dateTimeErro) {
		this.dateTimeErro = dateTimeErro;
	}

}
