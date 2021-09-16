import {Sector} from "./sector";

export class Registration {
  id!: number;
  name: string = '';
  sectors: Sector[] = [];
  terms: boolean = false;
}
