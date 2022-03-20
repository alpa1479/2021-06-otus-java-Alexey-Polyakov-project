import {UserTableElement} from "./user-table-element.model";

export class ProjectTableElement {

  id: number;
  title: string;
  status: string;
  owner: UserTableElement;
  createdDate: Date;
  updatedDate: Date;
  closedDate: Date;
}
