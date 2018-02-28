package com.datesgreat.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.datesgreat.entity.Article;

public class ClientUnitTest {
	public static void main(String[] args) {
		ClientUnitTest unitTest = new ClientUnitTest();
		
		unitTest.getArticleByIdTest();
		unitTest.getAllArticlesTest();
		unitTest.addArticleTest();
		unitTest.getAllArticlesTest();
		unitTest.updateArticleTest();
		unitTest.deleteArticleTest();
		unitTest.getAllArticlesTest();
	}
	
	public void getArticleByIdTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/article/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article.class, 1);
		
		Article article = responseEntity.getBody();
		if (article != null) {
			System.out.println("Id: " + article.getArticleId() + ", Title: " + article.getTitle() + ", Category: " + article.getCategory());
		} else {
			System.out.println("No article with Id 1");
		}
	}
	
	public void getAllArticlesTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/articles";
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Article[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article[].class);
		
		Article[] articles = responseEntity.getBody();
		if (articles != null) {
			for (Article article : articles) {
				System.out.println("Id: " + article.getArticleId() + ", Title: " + article.getTitle() + ", Category: " + article.getCategory());
			}
		} else {
			System.out.println("No any article!");
		}
	}
	
	public void addArticleTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/article";
		Article newArticle = new Article();
		newArticle.setTitle("Spring REST Security using Hibernate");
		newArticle.setCategory("Spring");
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(newArticle, headers);
		
		try {
			URI uri = restTemplate.postForLocation(url, requestEntity);
			System.out.println(uri.getPath());
		} catch (Exception e) {
			System.out.println("addArticleTest() causes EXCEPTION!!");
		}
	}
	
	public void updateArticleTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/article";
		Article newArticle = new Article();
		newArticle.setArticleId(1);
		newArticle.setTitle("Update: Java Streams");
		newArticle.setCategory("Java");
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(newArticle, headers);
		restTemplate.put(url, requestEntity);
	}
	
	public void deleteArticleTest() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article/{id}";
	    HttpEntity<Article> requestEntity = new HttpEntity<Article>(headers);
	    restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}
}
