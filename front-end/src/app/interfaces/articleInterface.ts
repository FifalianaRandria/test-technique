import { Panier } from "./panierInterface";

export interface Article {
    id: number;
    libelle: string;
    prix: number;
    panier?: Panier;
}