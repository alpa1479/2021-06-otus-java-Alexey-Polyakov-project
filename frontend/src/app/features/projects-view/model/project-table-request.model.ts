export class ProjectTableRequest {

  constructor(public page?: number,
              public size?: number,
              public sort?: string) {
  }

  public static from(page: number, size: number): ProjectTableRequest {
    return new ProjectTableRequest(page, size);
  }
}
