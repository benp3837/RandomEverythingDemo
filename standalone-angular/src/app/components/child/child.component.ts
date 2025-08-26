import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {

  //We can pass data from a parent to a child with @Input
  //The value is passed through property binding when the parent RENDERS the child 
  @Input() name: string = "";

}
