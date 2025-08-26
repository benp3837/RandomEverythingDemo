import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [CommonModule, FormsModule, ChildComponent],
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent {

  //A Component's TS file stores values and functions that affect the view and app behavior

  //Defining an Array that we'll use to render multiple child components
  arr:string[] = ["Jonny", "Bonnie", "Connie", "Jim"]

  //Defining the function that runs when the button is clicked
  showSurprise():void{
    alert("SURPRISE!!!")
  }

  //defining a variable to toggle the hidden div on and off
  hideDiv:boolean = true

  toggleHideDiv(){
    this.hideDiv = !this.hideDiv
  }

  //defining a variable to be populated by the two way binding
  name:string = ""

}
