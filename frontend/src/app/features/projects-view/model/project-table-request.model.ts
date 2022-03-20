export class ProjectTableRequest {

  constructor(public page: number,
              public size: number,
              public sort: string,
              public search: string) {
  }

  public static from(page: number, size: number, sort: string, direction: string, search: string): ProjectTableRequest {
    return new ProjectTableRequest(page, size, sort ? `${sort},${direction}` : '', search);
  }
}
