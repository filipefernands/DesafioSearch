package com.ffsrocha.desafiosearch.api.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ffsrocha.desafiosearch.api.entities.GoogleSearch;
import com.ffsrocha.desafiosearch.api.entities.QuerySearch;
import com.ffsrocha.desafiosearch.api.service.GoogleSearchService;
import com.ffsrocha.desafiosearch.api.service.QuerySearchService;


@RestController
@RequestMapping("/challenge/search")
@CrossOrigin(origins = "*")
public class GoogleSearchController {
	
	private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";
	private Object response;
	
	@Autowired
	private GoogleSearchService googleSearchService;
	
	
	@Autowired
	private QuerySearchService querySearchService;
	
	
	/**
	 * Executa a pesquisa no google ou base de dados local caso query informada já tenha sido 
	 * pesquisada.
	 * 
	 * @param query
	 * @return <response>
	 */
	@GetMapping
	public ResponseEntity<Object> search(@RequestParam("query") String query) throws IOException {
				
		
		// Checa se a query informada já foi pesquisada
		Optional<QuerySearch> querySearch = this.querySearchService.findByQuery(query);

		// Se não for encontrado resultados na base local a pesquisa é realizada no google
		if(!querySearch.isPresent()) {
			
			/**
			 * Devido o google limitar sua API de buscas em 100 consultas diárias, utilizei a abaordagem 
			 * de raspagem de dados, onde as informações são extraídas da página HTML
			 */
			final Document bodyHTML = Jsoup.connect(GOOGLE_SEARCH_URL + query + "&num=20").get();
			
			ArrayList<GoogleSearch> listResult = new ArrayList<GoogleSearch>();
			
			QuerySearch addQuery = new QuerySearch();
			
			addQuery.setQuery(query);
			this.querySearchService.persistir(addQuery);
			
			for(Element  result : bodyHTML.select("div.r a h3")) {
				
				GoogleSearch addSearch = new GoogleSearch();
				
				addSearch.setText(result.text());
				addSearch.setUrl(result.parent().attr("href"));
				addSearch.setIdQuery(addQuery.getId());
				listResult.add(addSearch);
				
			}
			
			this.googleSearchService.persistir(listResult);
			
			this.response = listToJson(this.googleSearchService.findByIdQuery(addQuery.getId()));
			
		}else {
			
			this.response = listToJson(this.googleSearchService.findByIdQuery(querySearch.get().getId()));
			
		}
		
		
		JSONObject response = new JSONObject();
		response.putOnce("query", query);
		response.putOnce("result", this.response);
		
		return ResponseEntity.ok(response.toMap());
		
	}
	
	
	/**
	 * Converte a lista com o resultado da pesquisa em JSON
	 * 
	 * {
	 * 	result: [{"text": "", "url": ""}, ...]
	 * }
	 *
	 * @param google
	 * @return <Object>
	 */
	private  JSONArray listToJson(List<GoogleSearch> google){
		
		JSONArray response = new JSONArray();
		
		for (int i = 0; i < google.size(); i++) {
			
			response.put(new JSONObject().put("text", google.get(i).getText())
					.put("url", google.get(i).getUrl()));
		}
		
		return response;
	
	}
	

}
