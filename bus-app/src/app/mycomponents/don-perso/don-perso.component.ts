import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { DatePipe } from '@angular/common';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { BusServiceService } from '../../myservices/bus-service.service';
import { ClientResponse } from './../models/clientresponse.model';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';

providers: [{
  provide: STEPPER_GLOBAL_OPTIONS, useValue: { showError: true }
}]
@Component({
  selector: 'app-don-perso',
  templateUrl: './don-perso.component.html',
  styleUrls: ['./don-perso.component.css']
})
export class DonPersoComponent implements OnInit {

  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;


  show: boolean = true;
  nbrPlaces: number;
  age: number;
  nom: string;
  prenom: string;
  idVoyage: string;
  person: {};
  clientResponse: ClientResponse;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private _formBuilder: FormBuilder,
    private service: BusServiceService) {
  }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      age: ['', [Validators.required, Validators.max(140)]],

    });

    this.secondFormGroup = this._formBuilder.group({
      nbrPlaces: ['', [Validators.required, Validators.max(5)]]
    });
    this.getId();
  }

  sendData(values) {
    let url = 'http://localhost:9090/newclient';
    this.show = false;
    this.person = {
      nom: this.nom,
      prenom: this.prenom,
      age: this.age,
      nbrPlaces: this.nbrPlaces,
      idVoyage: this.idVoyage
    }
    let date = new Date() ;
    let datePipe = new DatePipe('en')
     .transform(date.toString(), "dd-MM-yyyy");

    this.service.postRessources(url, this.person).subscribe(data => {
      this.clientResponse = <ClientResponse>data;
      console.log(this.clientResponse);
    }
    );

  }

  getId() {
    let url;
    url = atob(this.router.url.slice(7, this.router.url.length));
    this.idVoyage = url.slice(29, url.length)
  }


  generatePdf() {

    let data = document.getElementById('ticket');
    html2canvas(data).then(canvas => {
      // Few necessary setting options
      let imgWidth = 208;
      let pageHeight = 295;
      let imgHeight = canvas.height * imgWidth / canvas.width;
      let heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
      let position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdf.save('tcketSosVoyage.pdf'); // Generated PDF

    }) ;
 }
}
