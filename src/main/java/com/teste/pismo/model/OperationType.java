package com.teste.pismo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "OperationsTypes" )
public class OperationType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8335370523805282323L;


	@Id
	@Column( name = "Id" )
	private Integer id;
	
	@Column( name = "Description" )
	private String description;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
