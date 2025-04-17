import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { MatCard, MatCardActions, MatCardContent, MatCardHeader } from '@angular/material/card';
import { Panier } from '../../interfaces/panierInterface';
import { PanierServiceService } from '../../services/panier-service.service';
import { CommonModule } from '@angular/common';
import { Article } from '../../interfaces/articleInterface';
import { ArticleComponent } from '../article/article.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-panier',
  imports: [
    HeaderComponent,
    CommonModule,
    FormsModule,
    MatCard,
    MatCardContent
  ],
  templateUrl: './panier.component.html',
  styleUrl: './panier.component.css'
})
export class PanierComponent implements OnInit{

  constructor(
    public panierService: PanierServiceService
  ) {}

  ngOnInit(): void {
  }

  retirerDuPanier(article: Article) {
    this.panierService.retirer(article);
  }
}
 