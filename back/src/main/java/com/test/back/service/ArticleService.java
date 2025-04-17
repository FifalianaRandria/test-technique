package com.test.back.service;

import java.util.List;

import com.test.back.modele.Article;

public interface ArticleService {
    Article getById(Long id);
    Article creer(Article article);
    List<Article> lire();
    Article modifier(Long id, Article article);
    String supprimer(Long id);
}
