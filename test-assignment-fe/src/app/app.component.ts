import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Helmes test assignment';
  currentUrl: string = '';

  constructor(private router: Router) {
  }

  goToUrl(url: string) {
    this.router.navigate([url]);
    this.currentUrl = url;
  }

}
