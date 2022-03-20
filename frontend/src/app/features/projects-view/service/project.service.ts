import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ProjectTableElement} from "../model/project-table-element.model";
import {RepositoryService} from "../../../core/repository/repository.service";
import {Page} from "../../../shared/model/page.model";
import {ProjectTableRequest} from "../model/project-table-request.model";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private repository: RepositoryService<Page<ProjectTableElement>>) {
  }

  public getProjects(request?: ProjectTableRequest): Observable<Page<ProjectTableElement>> {
    let route: string = "api/projects";
    if (request?.page) {
      route += `?page=${request?.page}&size=${request?.size}`
    }
    if (request?.sort) {
      route += `&sort=${request?.sort}`
    }
    return this.repository.get(route);
  }
}
