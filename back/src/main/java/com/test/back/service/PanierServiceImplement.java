package com.test.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.back.modele.Article;
import com.test.back.modele.Panier;
import com.test.back.repository.ArticleRepository;
import com.test.back.repository.PanierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class PanierServiceImplement implements PanierService{
    
    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Panier createPanier(Panier panier) {
        if (panier.getArticles() != null) {
            List<Article> articlesFinal = new ArrayList<>();

            for (Article articleReq : panier.getArticles()) {
                Article article = articleRepository.findById(articleReq.getId())
                        .orElseThrow(() -> new RuntimeException("Article not found with id: " + articleReq.getId()));

                article.setPanier(panier);
                articlesFinal.add(article);
                break;
            }

            panier.setArticles(articlesFinal);
        }

        return panierRepository.save(panier);
    }

    @Override
    public Panier save(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public void ajouterArticleDansPanier(Long panierId, Long articleId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));

        article.setPanier(panier);
        articleRepository.save(article);
    }

    @Override
    public List<Panier> getAll() {
        return panierRepository.findAll();
    }

    @Override
    public void removeArticleFromPanier(Long panierId, Long articleId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier not found"));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        if (article.getPanier() == null || !article.getPanier().getId().equals(panierId)) {
            throw new RuntimeException("Article does not belong to this panier");
        }

        article.setPanier(null);
        articleRepository.save(article);
    }
}
