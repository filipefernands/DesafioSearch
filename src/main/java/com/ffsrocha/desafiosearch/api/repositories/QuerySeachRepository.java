package com.ffsrocha.desafiosearch.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ffsrocha.desafiosearch.api.entities.QuerySearch;

public interface QuerySeachRepository extends JpaRepository<QuerySearch, Long> {
	
	@Transactional(readOnly = true)
	QuerySearch findByQuery(String query);

}
