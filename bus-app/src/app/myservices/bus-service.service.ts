import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http' ;
import {  Observable  } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class BusServiceService {


  constructor(private http : HttpClient) { }



  getRessources(url){

   return  this.http.get(url) ;

  }
  postRessources(url, obj): Observable<Object>{

   return  this.http.post(url,obj) ;

  }

}
