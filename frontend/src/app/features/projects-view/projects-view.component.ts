import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {ProjectService} from "./service/project.service";
import {ProjectTableElement} from "./model/project-table-element.model";
import {Page} from "../../shared/model/page.model";
import {ProjectTableRequest} from "./model/project-table-request.model";

@Component({
  selector: 'app-projects-view',
  templateUrl: './projects-view.component.html',
  styleUrls: ['./projects-view.component.css']
})
export class ProjectsViewComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['title', 'status', 'owner', 'created date', 'updated date', 'closed date'];
  dataSource: MatTableDataSource<ProjectTableElement> = new MatTableDataSource<ProjectTableElement>();
  pageSizeOptions: number[] = [10];
  loading: boolean = false;
  totalCount: number = 0;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private projectService: ProjectService) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this._initProjectsTable();
  }

  public onRowClicked(event: any): void {
    console.log('>>>> onRowClicked', event);
  }

  public onSortChange(sortState: Sort): void {
    console.log('>>>> onSortChange', sortState);
  }

  public onPageChange(pageState: PageEvent): void {
    this.loading = true;
    console.log('>>>> onPageChange', pageState);
    this.projectService.getProjects(ProjectTableRequest.from(pageState.pageIndex, pageState.pageSize)).subscribe((projects: Page<ProjectTableElement>) => {
      console.log('>>> onPageChange getProjects', projects);
      this.dataSource.data = projects.elements;
      setTimeout(() => {
        this.paginator.pageIndex = pageState.pageIndex;
        this.paginator.length = projects.totalCount;
      });
      this.loading = false;
    })
  }

  private _initProjectsTable(): void {
    this.loading = true;
    this.projectService.getProjects().subscribe((projects: Page<ProjectTableElement>) => {
      console.log('>>> _initProjectsTable', projects);
      this.totalCount = projects.totalCount;
      this.dataSource.data = projects.elements;
      this.loading = false;
    })
  }
}
