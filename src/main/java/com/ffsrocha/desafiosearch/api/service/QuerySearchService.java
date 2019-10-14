package com.ffsrocha.desafiosearch.api.service;

import java.util.Optional;

import com.ffsrocha.desafiosearch.api.entities.QuerySearch;


public interface QuerySearchService {
	
	/**
	 * Retorna a query pesquisada
	 * 
	 * @param query
	 * @return Optional<QuerySearch>
	 */
	Optional<QuerySearch> findByQuery(String query);
	
	/**
	 * Persiste a query pesquisada no banco de dados
	 * 
	 * @param querySearch
	 */
	void persistir(QuerySearch querySearch);

}
