import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-translator',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './translator.component.html',
  styleUrls: ['./translator.component.css']
})
export class TranslatorComponent {

  title = 'pig-latin-translator';

  englishText: string = '';
  pigLatinText: string = '';


  translate(){
    
    //Ripped directly from Github Copilot
    let words:string[] = this.englishText.split(" ");

    let pigLatin:string = ""

    for(let word of words) {
        if (word.length > 0) {
            let firstLetter:string = word.charAt(0);
            let pigLatinWord:string = word.substring(1) + firstLetter + "ay";
            this.pigLatinText += (pigLatinWord + " ");
        }
    }


  }

}
