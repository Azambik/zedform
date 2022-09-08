import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {InputTextModule} from 'primeng/inputtext';
import { CreateAccountComponent } from './create-account.component';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';



@NgModule({
  declarations: [CreateAccountComponent],
  imports: [
    CommonModule,
    InputTextModule,
    FormsModule,
    ButtonModule
  ],
  exports:[
    CreateAccountComponent
  ]
})
export class CreateAccountModule { }
