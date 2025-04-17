package com.test.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.back.modele.Article;
import com.test.back.modele.Panier;
import com.test.back.repository.PanierRepository;
import com.test.back.service.PanierService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/panier")
@AllArgsConstructor

public class PanierController {

    @Autowired
    private PanierService panierService;
    private PanierRepository panierRepository;

    @GetMapping("/read")
    public List<Panier> getAll() {
        return panierService.getAll();
    }

    @GetMapping("/{id}/articles")
    public List<Article> getArticlesByPanierId(@PathVariable Long id) {
        Panier panier = panierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        return panier.getArticles();
    }

    @PostMapping("/create")
    public Panier createPanier(@RequestBody Panier panier) {
        return panierService.createPanier(panier);
    }

    @PutMapping("/{panierId}/articles/{articleId}")
    public ResponseEntity<String> ajouterArticleDansPanier(
            @PathVariable Long panierId,
            @PathVariable Long articleId,
            @RequestBody Panier panier) {

        panierService.ajouterArticleDansPanier(panierId, articleId);

        return ResponseEntity.ok("Article ajouté au panier !");
    }

    @DeleteMapping("/{panierId}/articles/{articleId}")
    public ResponseEntity<String> removeArticleFromPanier(
            @PathVariable Long panierId,
            @PathVariable Long articleId) {

        panierService.removeArticleFromPanier(panierId, articleId);
        return ResponseEntity.ok("Article détaché du panier avec succès");
    }

    @PostMapping
    public ResponseEntity<Panier> create(@RequestBody Panier panier) {
        Panier panierSauve = panierService.save(panier);
        return ResponseEntity.status(HttpStatus.CREATED).body(panierSauve);
    }

    // @PutMapping("/{panierId}/articles/{articleId}")
    // public ResponseEntity<String, String> ajouterArticleDansPanier(
    //         @PathVariable Long panierId,
    //         @PathVariable Long articleId) {

    //     panierService.ajouterArticleDansPanier(panierId, articleId);

    //     Map<String, String> response = new HashMap<>();
    //     response.put("message", "Article ajouté au panier !");
        
    //     return ResponseEntity.ok(response);
    // }
}


