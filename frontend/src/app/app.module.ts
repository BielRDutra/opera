import { NgModule, importProvidersFrom } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { bootstrapApplication } from '@angular/platform-browser';

@NgModule({
  imports: [BrowserModule],
})
export class AppModule { }

bootstrapApplication(AppComponent, {
  providers: [importProvidersFrom(AppModule)]
});
