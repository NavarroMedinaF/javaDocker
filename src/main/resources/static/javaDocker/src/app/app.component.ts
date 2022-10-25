import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ColDef } from 'ag-grid-community';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  rowData:any[]=[];

  colDeft: ColDef[]=[
    {field:'make'},
    {field: 'model'},
    {field:'price'}
  ]
}
