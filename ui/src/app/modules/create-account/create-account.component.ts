import { Component, OnInit } from '@angular/core';
import { CreateAccountService } from '../create-account/create-account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserAccount } from '../../models/UserAccount.model';

@Component({
  selector: 'create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.scss']
})
export class CreateAccountComponent implements OnInit {

  userAccount: UserAccount ={
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phoneNumber: ''
  }
  constructor(
    private createAccountService: CreateAccountService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  editUser(id: string): void {
    this.createAccountService.get(id)
      .subscribe(
        data => {
          this.userAccount = data;
        },
        error => {
          console.error(error);
        });
  }

  saveUser(): void {
      this.createNewUser();
  }

  private createNewUser() {
    this.createAccountService.create(this.userAccount)
      .subscribe(
        response => {
          this.router.navigate([ '/userAccount' ]);
        },
        error => {
          console.error(error);
          console.log('An error occurred while saving User');
        });
  }

  private saveEditedUser() {
    this.createAccountService.update(this.userAccount.id, this.userAccount)
      .subscribe(
        response => {
          this.router.navigate([ '/userAccount' ]);
        },
        error => {
          console.error(error);
          console.log('An error occurred while saving User');
        });
  }

  test(){
    console.log(this.userAccount);
    this.saveUser()
  }

}
