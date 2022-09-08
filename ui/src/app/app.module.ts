import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { CreateAccountComponent } from './modules/create-account/create-account.component';
import { FormsModule } from '@angular/forms';
import { CreateAccountModule } from './modules/create-account/create-account.module';
import { CreateAccountService } from './modules/create-account/create-account.service';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    //CreateAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CreateAccountModule,
    HttpClientModule
    
  ],
  providers: [CreateAccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
