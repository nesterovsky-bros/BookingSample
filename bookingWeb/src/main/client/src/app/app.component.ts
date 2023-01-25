import { Component } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { ImportersClientService } from './importers-client.service';
import { City } from './model/city';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  search?: string;
  cities?: City[];

  constructor(protected importers: ImportersClientService)
  {

  }

  async doSearch()
  {
    this.cities = await firstValueFrom(this.importers.searchCity(this.search));
  }
}
