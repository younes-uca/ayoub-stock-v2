import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
@Component({
  selector: 'app-fournisseur-create-admin',
  templateUrl: './fournisseur-create-admin.component.html'
})
export class FournisseurCreateAdminComponent extends AbstractCreateController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {



   private _validFournisseurNom = true;
    private _validVilleLibelle = true;

    constructor( private fournisseurService: FournisseurAdminService , private villeService: VilleAdminService) {
        super(fournisseurService);
    }

    ngOnInit(): void {
        this.ville = new VilleDto();
        this.villeService.findAll().subscribe((data) => this.villes = data);
    }





    public setValidation(value: boolean){
        this.validFournisseurNom = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFournisseurNom();
    }

    public validateFournisseurNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validFournisseurNom = false;
        } else {
            this.validFournisseurNom = true;
        }
    }


    public async openCreateVille(ville: string) {
    const isPermistted = await this.roleService.isPermitted('Ville', 'add');
    if(isPermistted) {
         this.ville = new VilleDto();
         this.createVilleDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get ville(): VilleDto {
        return this.villeService.item;
    }
    set ville(value: VilleDto) {
        this.villeService.item = value;
    }
    get villes(): Array<VilleDto> {
        return this.villeService.items;
    }
    set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
    }
    get createVilleDialog(): boolean {
       return this.villeService.createDialog;
    }
    set createVilleDialog(value: boolean) {
        this.villeService.createDialog= value;
    }



    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }

    set validFournisseurNom(value: boolean) {
         this._validFournisseurNom = value;
    }

    get validVilleLibelle(): boolean {
        return this._validVilleLibelle;
    }
    set validVilleLibelle(value: boolean) {
        this._validVilleLibelle = value;
    }


}
