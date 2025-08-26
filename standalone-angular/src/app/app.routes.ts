import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TranslatorComponent } from './components/translator/translator.component';

export const routes: Routes = [
    {
        path:"",
        component:HomeComponent
    },
    {
        path:"translator",
        component:TranslatorComponent
    }
];
