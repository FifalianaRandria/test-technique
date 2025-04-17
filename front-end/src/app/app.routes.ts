import { RouterModule, Routes } from '@angular/router';
import { ArticleComponent } from './components/article/article.component';
import { NgModule } from '@angular/core';
import { PanierComponent } from './components/panier/panier.component';

export const routes: Routes = [
    {
        path:'article',
        component: ArticleComponent
    },
    {
        path:'panier',
        component: PanierComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutes {}