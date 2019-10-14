package com.ffsrocha.desafiosearch.api.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "search")
public class GoogleSearch implements Serializable {

	private static final long serialVersionUID = 3706423526914804801L;
	
	
	private Long id;
	private String text;
	private String url;
	private Long idQuery;
	
	public GoogleSearch() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "text", nullable = false)
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Basic
	@Column(name = "id_query")
	public Long getIdQuery() {
		return idQuery;
	}
	
	public void setIdQuery(Long idQuery) {
		this.idQuery = idQuery;
	}
	
	
	
	@Override
	public String toString() {
		return "GoogleSearch [id=" + id + ", text=" + text + ", url=" + url + "id_query=" + idQuery+ "]";
	}
	
	

}
