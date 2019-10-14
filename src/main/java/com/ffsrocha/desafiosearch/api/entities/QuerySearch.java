package com.ffsrocha.desafiosearch.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query_search")
public class QuerySearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7684121225066762427L;
	
	
	private Long id;
	private String query;
	
	public QuerySearch() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "query")
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		return "query [id=" + id + ", query=" + query + "]";
	}
	
	

}
