import { Component, AfterViewInit, ViewChild, OnInit } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { ArticleService } from '../../services/article.service';
import { Article } from '../../interfaces/articleInterface';
import {MatCardModule} from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HeaderComponent } from '../header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { PanierServiceService } from '../../services/panier-service.service';
import { Router } from 'express';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [
    HttpClientModule,
    HeaderComponent,
    MatCardModule,
    MatPaginatorModule,
    MatPaginatorModule,
    MatTableModule,
    MatFormFieldModule,
    CommonModule
  ],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})

export class ArticleComponent implements OnInit{
  total: number = -1;
  displayedColumns = ['id', 'libelle', 'prix', 'action']
  article: Article[] = [];
  panierId = 1;
  dataSource: MatTableDataSource<Article, MatPaginator>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort:MatSort;

  constructor(
    private service: ArticleService,
    private panierService: PanierServiceService
  ) {}

  ngOnInit(): void {
      this.getArticle();
  }

  getArticle(){
    this.service.getArticle().subscribe((res: Article[]) => {
      this.dataSource = new MatTableDataSource(res);
      this.total = res.length;
    })
  }

  ajouter(article: Article) {
    alert('Article ajouté au panier !');
    this.panierService.ajouter(article);
  }

  // Ajouter un article dans le panier
  // ajouter(articleId: number) {
  //   this.panierService.ajouterArticleDansPanier(this.panierId, articleId).subscribe({
  //     next: (res) => {
  //       alert('Article ajouté au panier !');
  //     },
  //     error: (err) => {
  //       console.error(err);
  //       alert('Erreur lors de l\'ajout de l\'article');
  //     }
  //   });
  // }
}
