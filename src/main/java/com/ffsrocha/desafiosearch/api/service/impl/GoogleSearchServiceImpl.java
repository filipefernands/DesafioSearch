package com.ffsrocha.desafiosearch.api.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ffsrocha.desafiosearch.api.entities.GoogleSearch;
import com.ffsrocha.desafiosearch.api.service.GoogleSearchService;
import com.ffsrocha.desafiosearch.api.repositories.GoogleSearchRepository;

@Service
public class GoogleSearchServiceImpl implements GoogleSearchService{
	
	private static final Logger log = LoggerFactory.getLogger(GoogleSearchServiceImpl.class);
	
	@Autowired
	private GoogleSearchRepository googleSearchRepository;

	@Override
	public void persistir(ArrayList<GoogleSearch> googleSearch) {
		log.info("Gravando resultados das pesquisas no banco de dados"); 
		this.googleSearchRepository.saveAll(googleSearch);
	}
	
	@Cacheable("SearchByIdQuery")
	public List<GoogleSearch> findByIdQuery(Long idQuery) {
		return this.googleSearchRepository.findByIdQuery(idQuery);
	}

	

}
