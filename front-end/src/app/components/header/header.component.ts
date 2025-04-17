import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../../interfaces/menuInterface';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  imports:[
    MatToolbarModule,
    CommonModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})

export class HeaderComponent implements OnInit{

  constructor(private router: Router) {}

  ngOnInit(): void {
  }
}
