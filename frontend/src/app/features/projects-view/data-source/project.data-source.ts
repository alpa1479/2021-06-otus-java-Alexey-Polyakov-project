import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {ProjectTableElement} from "../model/project-table-element.model";
import {BehaviorSubject, catchError, finalize, Observable, of} from "rxjs";
import {ProjectService} from "../service/project.service";
import {Page} from "../../../shared/model/page.model";
import {ProjectTableRequest} from "../model/project-table-request.model";

export class ProjectDataSource implements DataSource<ProjectTableElement> {

  private projectsSubject = new BehaviorSubject<ProjectTableElement[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  private totalCountSubject = new BehaviorSubject<number>(0);

  public loading$ = this.loadingSubject.asObservable();
  public totalCount$ = this.totalCountSubject.asObservable();

  constructor(private projectService: ProjectService) {
  }

  connect(collectionViewer: CollectionViewer): Observable<ProjectTableElement[]> {
    return this.projectsSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.projectsSubject.complete();
    this.loadingSubject.complete();
  }

  loadProjects(request?: ProjectTableRequest): void {
    this.loadingSubject.next(true);
    this.projectService.getProjects(request).pipe(
      catchError(() => of(new Page([], 0, 0))),
      finalize(() => this.loadingSubject.next(false))
    ).subscribe((projectsPage: Page<ProjectTableElement>) => {
      this.totalCountSubject.next(projectsPage.totalCount);
      this.projectsSubject.next(projectsPage.elements);
    })
  }
}
