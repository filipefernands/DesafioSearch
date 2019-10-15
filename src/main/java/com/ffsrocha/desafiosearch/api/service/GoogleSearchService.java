package com.ffsrocha.desafiosearch.api.service;


import java.util.ArrayList;
import java.util.List;

import com.ffsrocha.desafiosearch.api.entities.GoogleSearch;

public interface GoogleSearchService {
	
	/**
	 * Persiste o resultado a pesquisa no banco de dados
	 * 
	 * @param empresa
	 * @return void
	 */
    void persistir(ArrayList<GoogleSearch> googleSearch);
    
    /**
     * Retorna uma lista de pesquisa
     * 
     * @param idQuery
     * @return List<GoogleSearch>
     */
	List<GoogleSearch> findByIdQuery(Long idQuery);
	
}
