import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sector} from "../model/sector";

@Injectable()
export class SectorService {

  private sectorsUrl: string;

  constructor(private http: HttpClient) {
    this.sectorsUrl = 'http://localhost:8080/sectors/';
  }

  public findAll(): Observable<Sector[]> {
    return this.http.get<Sector[]>(this.sectorsUrl);
  }
}
