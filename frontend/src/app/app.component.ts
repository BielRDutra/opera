import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Opera';
  theme: 'blue' | 'red' = 'blue';

  toggleTheme() {
    this.theme = this.theme === 'blue' ? 'red' : 'blue';
    document.body.classList.remove('theme-blue', 'theme-red');
    document.body.classList.add(`theme-${this.theme}`);
  }
}
