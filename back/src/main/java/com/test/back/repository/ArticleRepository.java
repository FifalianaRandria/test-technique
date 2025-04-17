package com.test.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.back.modele.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    

}
