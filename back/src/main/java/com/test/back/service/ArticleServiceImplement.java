package com.test.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.back.modele.Article;
import com.test.back.repository.ArticleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleServiceImplement implements ArticleService{
    @Autowired
    private final ArticleRepository articleRepository;

    @Override
    public Article creer(Article article) {
        return articleRepository.save(article);
    }

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    @Override
    public List<Article> lire() {
        return articleRepository.findAll();
    }

    @Override
    public Article modifier(Long id, Article article) {
        return articleRepository.findById(id).map(a -> {
            a.setPrix(article.getPrix());
            a.setLibelle(article.getLibelle());
            return articleRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Article non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        articleRepository.deleteById(id);
        return "Article supprimé";
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findById(id).orElseThrow();
    }

}
