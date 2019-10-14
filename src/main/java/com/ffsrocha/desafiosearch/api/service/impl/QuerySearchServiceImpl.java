package com.ffsrocha.desafiosearch.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffsrocha.desafiosearch.api.entities.QuerySearch;
import com.ffsrocha.desafiosearch.api.service.QuerySearchService;
import com.ffsrocha.desafiosearch.api.repositories.QuerySeachRepository;

@Service
public class QuerySearchServiceImpl  implements QuerySearchService{
	
	@Autowired
	private QuerySeachRepository querySearchRepository;

	@Override
	public Optional<QuerySearch> findByQuery(String query) {
		return Optional.ofNullable(this.querySearchRepository.findByQuery(query));
	}

	@Override
	public void persistir(QuerySearch querySearch) {
		this.querySearchRepository.save(querySearch);
	}

	
}
