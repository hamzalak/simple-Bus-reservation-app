import { BrowserModule } from '@angular/platform-browser';
import  { HttpClientModule} from '@angular/common/http' ;
 import { NgModule,  } from '@angular/core';
 import { AppRoutingModule } from './app-routing.module';
 import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
 import {  ReactiveFormsModule, FormsModule } from '@angular/forms' ;
 import { AppComponent } from './app.component';
import {
MatStepperModule,
MatProgressSpinnerModule,
MatTooltipModule  ,
MatDatepickerModule ,
MatInputModule ,
MatFormFieldModule ,
MatNativeDateModule,
MatButtonModule,
MAT_DATE_LOCALE } from '@angular/material' ;
import { DatevoyageComponent } from './mycomponents/datevoyage/datevoyage.component';
import { HorairesComponent } from './mycomponents/horaires/horaires.component';
import { NaviComponent } from './mycomponents/navi/navi.component';
import { DonPersoComponent } from './mycomponents/don-perso/don-perso.component';
@NgModule({
  declarations: [
    AppComponent,
    DatevoyageComponent,
    HorairesComponent,
    NaviComponent,
    DonPersoComponent,
  ],
  imports: [
       BrowserModule,
       AppRoutingModule,
       FormsModule,
       ReactiveFormsModule,
       HttpClientModule,
       MatDatepickerModule ,
       MatInputModule ,
       MatFormFieldModule ,
       MatNativeDateModule ,
       BrowserAnimationsModule,
       MatProgressSpinnerModule,
       MatStepperModule,
       MatButtonModule,
       MatTooltipModule
  ],
  providers: [{provide : MAT_DATE_LOCALE , useValue : "fr-FR" }],
  bootstrap: [AppComponent]
})
export class AppModule { }
