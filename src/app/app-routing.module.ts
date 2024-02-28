import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { QuestionDetailsComponent } from './question-details/question-details.component';

const routes: Routes = [
  {path:'',component : HomeComponent},
  {path:'question',component : QuestionDetailsComponent},
  {path : 'login',component : LoginComponent},
  {path:'**',component:ErrorPageComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }