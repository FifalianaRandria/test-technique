import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from '../interfaces/articleInterface';
import { Panier } from '../interfaces/panierInterface';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  readonly article = "http://localhost:8080/article/read"

  constructor(
    private http: HttpClient
  ) { }

  getArticle(): Observable<Article[]> {
    return this.http.get<Article[]>(this.article);
  }

  getById(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.article}/${id}`);
  }

  postArticle(val: Article) {
    return this.http.post(this.article  + '/create', val);
  }

  putArticle(id: number, val: any) {
    return this.http.put(this.article + '/update', + id, val);
  }

  deleteArticle(id: number) {
    return this.http.delete(this.article + '/delete' + id)
  }
}
