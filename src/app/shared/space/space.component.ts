import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'space',
  templateUrl: './space.component.html',
  styleUrls: ['./space.component.css']
})
export class SpaceComponent implements OnInit {

  @Input() title : string;
  constructor() {
    this.title = '';
  }

  ngOnInit(): void {
  }

}
