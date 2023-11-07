import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';
@Component({
  selector: 'app-proprietaire-create-admin',
  templateUrl: './proprietaire-create-admin.component.html'
})
export class ProprietaireCreateAdminComponent extends AbstractCreateController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService>  implements OnInit {



   private _validProprietaireNom = true;

    constructor( private proprietaireService: ProprietaireAdminService ) {
        super(proprietaireService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validProprietaireNom = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProprietaireNom();
    }

    public validateProprietaireNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validProprietaireNom = false;
        } else {
            this.validProprietaireNom = true;
        }
    }






    get validProprietaireNom(): boolean {
        return this._validProprietaireNom;
    }

    set validProprietaireNom(value: boolean) {
         this._validProprietaireNom = value;
    }



}
