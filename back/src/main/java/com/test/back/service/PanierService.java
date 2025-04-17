package com.test.back.service;


import java.util.List;

import com.test.back.modele.Panier;

public interface PanierService {
    Panier createPanier(Panier panier);
    Panier save(Panier panier);
    List<Panier> getAll();
    void ajouterArticleDansPanier(Long panierId, Long articleId);
    void removeArticleFromPanier(Long panierId, Long articleId);
}
