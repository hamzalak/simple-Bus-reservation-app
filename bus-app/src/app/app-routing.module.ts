import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HorairesComponent } from './mycomponents/horaires/horaires.component' ;
import { DatevoyageComponent } from './mycomponents/datevoyage/datevoyage.component' ;
import { DonPersoComponent } from './mycomponents/don-perso/don-perso.component' ;


const routes: Routes = [ {path: 'home' , component : DatevoyageComponent},
                        {path:'horaires/:infoUrl' , component : HorairesComponent } ,
                        {path: 'perso/:id' , component : DonPersoComponent },
                        {path :'', redirectTo: '/home', pathMatch:'full'}
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
