package com.test.back.controller;

import java.util.List;

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
import com.test.back.service.ArticleService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/create")
    public Article create(@RequestBody Article article){
        return articleService.creer(article);
    }

    @GetMapping("/read")
    public List<Article> read(){
        return articleService.lire();
    }

    @GetMapping("/read/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article){
        return articleService.modifier(id, article);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return articleService.supprimer(id);
    }
}