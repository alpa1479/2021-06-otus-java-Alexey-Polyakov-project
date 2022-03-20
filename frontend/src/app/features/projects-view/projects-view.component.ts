import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {ProjectService} from "./service/project.service";
import {ProjectDataSource} from "./data-source/project.data-source";
import {debounceTime, distinctUntilChanged, fromEvent, merge, tap} from "rxjs";
import {ProjectTableRequest} from "./model/project-table-request.model";

@Component({
  selector: 'app-projects-view',
  templateUrl: './projects-view.component.html',
  styleUrls: ['./projects-view.component.css']
})
export class ProjectsViewComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['title', 'status_id', 'owner_username', 'created_date', 'updated_date', 'closed_date'];
  dataSource: ProjectDataSource;
  pageSizeOptions: number[] = [10];
  loading: boolean = false;
  totalCount: number = 0;

  @ViewChild('search') search: ElementRef;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private projectService: ProjectService) {
  }

  ngAfterViewInit() {
    fromEvent(this.search.nativeElement, 'keyup').pipe(
      debounceTime(150),
      distinctUntilChanged(),
      tap(() => {
        if (this.search.nativeElement.value.length >= 3) {
          this.paginator.pageIndex = 0;
          this._loadProjectsPage();
        }
      })).subscribe();
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);
    merge(this.sort.sortChange, this.paginator.page).pipe(tap(() => this._loadProjectsPage())).subscribe();
  }

  ngOnInit() {
    this.dataSource = new ProjectDataSource(this.projectService);
    this.dataSource.loadProjects();
  }

  public onRowClicked(event: any): void {
    console.log('>>>> onRowClicked', event);
  }

  public _reset(): void {
    if (this.search.nativeElement.value) {
      this.search.nativeElement.value = '';
      this.paginator.pageIndex = 0
      this.dataSource.loadProjects();
    }
  }

  private _loadProjectsPage() {
    this.dataSource.loadProjects(ProjectTableRequest.from(
      this.paginator.pageIndex,
      this.paginator.pageSize,
      this.sort.active,
      this.sort.direction,
      this.search.nativeElement.value
    ));
  }
}
