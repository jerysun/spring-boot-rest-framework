package com.datesgreat.service;

import java.util.ArrayList;
import java.util.List;

/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datesgreat.entity.Article;
import com.datesgreat.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Article getArticleById(long articleId) {
		//Article obj = articleRepository.findById(articleId).get();//Don't know why findById() doesn't work
		Article obj = articleRepository.findOne(articleId);
		return obj;
		/*
		final String PERSISTENCE_UNIT_NAME = "Article";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Article a WHERE a.articleId = :articleId");
		
		Article article = null;
		try {
			article = (Article) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
		*/
	}

	@Override
	public List<Article> getAllArticles() {
		List<Article> articles = new ArrayList<>();
		articleRepository.findAll().forEach(e -> articles.add(e));
		return articles;
	}

	@Override
	public boolean addArticle(Article article) {
		List<Article> articles = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
		if (articles.size() > 0) {
			return false;
		} else {
		    articleRepository.save(article);
		}
		return true;
	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleRepository.delete(getArticleById(articleId));
	}
}
