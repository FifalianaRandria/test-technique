import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Panier } from '../interfaces/panierInterface';
import { Article } from '../interfaces/articleInterface';

@Injectable({
  providedIn: 'root'
})
export class PanierServiceService {
  // private panierUrl = 'http://localhost:8080/panier';

  constructor(
    private http: HttpClient
  ) { }

  private panier: any[] = [];

  getPanier() {
    return this.panier;
  }

  ajouter(article: any) {
    this.panier.push(article);
  }

  retirer(article: any) {
    this.panier = this.panier.filter(a => a.id !== article.id);
  }

  // createPanier(panier: Panier): Observable<Panier> {
  //   return this.http.post<Panier>(`${this.panierUrl}`, panier);
  // }

  // Ajouter un article au panier
  // ajouterArticleDansPanier(panierId: number, articleId: number): Observable<any> {
  //   return this.http.post(`${this.panierUrl}/${panierId}/articles/${articleId}`, {});
  // }

  // // Récupérer les articles du panier
  // getArticlesDuPanier(panierId: number): Observable<Article[]> {
  //   return this.http.get<Article[]>(`${this.panierUrl}/${panierId}/articles`);
  // }

  // // Retirer un article du panier
  // retirerArticleDuPanier(panierId: number, articleId: number): Observable<any> {
  //   return this.http.delete(`${this.panierUrl}/${panierId}/articles/${articleId}`);
  // }
}
