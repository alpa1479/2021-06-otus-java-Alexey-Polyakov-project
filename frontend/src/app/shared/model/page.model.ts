export class Page<T> {

  constructor(public elements: T[], public currentSize: number, public totalCount: number) {
  }
}
