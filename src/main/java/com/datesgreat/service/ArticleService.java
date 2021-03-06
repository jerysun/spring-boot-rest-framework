package com.datesgreat.service;

import java.util.List;
import com.datesgreat.entity.Article;

public interface ArticleService {
	List<Article> getAllArticles();
	Article getArticleById(long articleId);
	boolean addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(int articleId);
}
