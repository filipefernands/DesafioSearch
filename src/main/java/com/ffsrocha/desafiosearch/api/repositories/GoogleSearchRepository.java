package com.ffsrocha.desafiosearch.api.repositories;


import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ffsrocha.desafiosearch.api.entities.GoogleSearch;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "GoogleSearchRepository.findByIdQuery",
			query = "SELECT g FROM GoogleSearch g WHERE g.search.id_query = :idQuery")
})
public interface GoogleSearchRepository extends JpaRepository<GoogleSearch, Long> {
	
	List<GoogleSearch> findByIdQuery(@Param("idQuery") Long idQuery);
		
}
