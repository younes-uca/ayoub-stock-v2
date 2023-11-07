import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProprietaireBanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireBanqueAdmin.service';
import {ProprietaireBanqueDto} from 'src/app/controller/model/gestionchequeffet/ProprietaireBanque.model';
import {ProprietaireBanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireBanqueCriteria.model';


import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';

@Component({
  selector: 'app-proprietaire-banque-edit-admin',
  templateUrl: './proprietaire-banque-edit-admin.component.html'
})
export class ProprietaireBanqueEditAdminComponent extends AbstractEditController<ProprietaireBanqueDto, ProprietaireBanqueCriteria, ProprietaireBanqueAdminService>   implements OnInit {


    private _validProprietaireBanqueProprietaire = true;
    private _validProprietaireBanqueBanque = true;
    private _validProprietaireBanqueCompte = true;

    private _validProprietaireNom = true;
    private _validBanqueLibelle = true;
    private _validBanqueCode = true;
    private _validCompteNumeroCompte = true;
    private _validCompteBanque = true;
    private _validCompteProprietaire = true;



    constructor( private proprietaireBanqueService: ProprietaireBanqueAdminService , private banqueService: BanqueAdminService, private proprietaireService: ProprietaireAdminService, private compteService: CompteAdminService) {
        super(proprietaireBanqueService);
    }

    ngOnInit(): void {
        this.proprietaire = new ProprietaireDto();
        this.proprietaireService.findAll().subscribe((data) => this.proprietaires = data);
        this.banque = new BanqueDto();
        this.banqueService.findAll().subscribe((data) => this.banques = data);
        this.compte = new CompteDto();
        this.compteService.findAll().subscribe((data) => this.comptes = data);
    }


    public setValidation(value: boolean){
        this.validProprietaireBanqueProprietaire = value;
        this.validProprietaireBanqueBanque = value;
        this.validProprietaireBanqueCompte = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProprietaireBanqueProprietaire();
        this.validateProprietaireBanqueBanque();
        this.validateProprietaireBanqueCompte();
    }
    public validateProprietaireBanqueProprietaire(){
        if (this.stringUtilService.isEmpty(this.item.proprietaire)) {
            this.errorMessages.push('Proprietaire non valide');
            this.validProprietaireBanqueProprietaire = false;
        } else {
            this.validProprietaireBanqueProprietaire = true;
        }
    }
    public validateProprietaireBanqueBanque(){
        if (this.stringUtilService.isEmpty(this.item.banque)) {
            this.errorMessages.push('Banque non valide');
            this.validProprietaireBanqueBanque = false;
        } else {
            this.validProprietaireBanqueBanque = true;
        }
    }
    public validateProprietaireBanqueCompte(){
        if (this.stringUtilService.isEmpty(this.item.compte)) {
            this.errorMessages.push('Compte non valide');
            this.validProprietaireBanqueCompte = false;
        } else {
            this.validProprietaireBanqueCompte = true;
        }
    }



   public async openCreateProprietaire(proprietaire: string) {
        const isPermistted = await this.roleService.isPermitted('Proprietaire', 'edit');
        if (isPermistted) {
             this.proprietaire = new ProprietaireDto();
             this.createProprietaireDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateBanque(banque: string) {
        const isPermistted = await this.roleService.isPermitted('Banque', 'edit');
        if (isPermistted) {
             this.banque = new BanqueDto();
             this.createBanqueDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateCompte(compte: string) {
        const isPermistted = await this.roleService.isPermitted('Compte', 'edit');
        if (isPermistted) {
             this.compte = new CompteDto();
             this.createCompteDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get proprietaire(): ProprietaireDto {
       return this.proprietaireService.item;
   }
  set proprietaire(value: ProprietaireDto) {
        this.proprietaireService.item = value;
   }
   get proprietaires(): Array<ProprietaireDto> {
        return this.proprietaireService.items;
   }
   set proprietaires(value: Array<ProprietaireDto>) {
        this.proprietaireService.items = value;
   }
   get createProprietaireDialog(): boolean {
       return this.proprietaireService.createDialog;
   }
  set createProprietaireDialog(value: boolean) {
       this.proprietaireService.createDialog= value;
   }
   get banque(): BanqueDto {
       return this.banqueService.item;
   }
  set banque(value: BanqueDto) {
        this.banqueService.item = value;
   }
   get banques(): Array<BanqueDto> {
        return this.banqueService.items;
   }
   set banques(value: Array<BanqueDto>) {
        this.banqueService.items = value;
   }
   get createBanqueDialog(): boolean {
       return this.banqueService.createDialog;
   }
  set createBanqueDialog(value: boolean) {
       this.banqueService.createDialog= value;
   }
   get compte(): CompteDto {
       return this.compteService.item;
   }
  set compte(value: CompteDto) {
        this.compteService.item = value;
   }
   get comptes(): Array<CompteDto> {
        return this.compteService.items;
   }
   set comptes(value: Array<CompteDto>) {
        this.compteService.items = value;
   }
   get createCompteDialog(): boolean {
       return this.compteService.createDialog;
   }
  set createCompteDialog(value: boolean) {
       this.compteService.createDialog= value;
   }


    get validProprietaireBanqueProprietaire(): boolean {
        return this._validProprietaireBanqueProprietaire;
    }
    set validProprietaireBanqueProprietaire(value: boolean) {
        this._validProprietaireBanqueProprietaire = value;
    }
    get validProprietaireBanqueBanque(): boolean {
        return this._validProprietaireBanqueBanque;
    }
    set validProprietaireBanqueBanque(value: boolean) {
        this._validProprietaireBanqueBanque = value;
    }
    get validProprietaireBanqueCompte(): boolean {
        return this._validProprietaireBanqueCompte;
    }
    set validProprietaireBanqueCompte(value: boolean) {
        this._validProprietaireBanqueCompte = value;
    }

    get validProprietaireNom(): boolean {
        return this._validProprietaireNom;
    }
    set validProprietaireNom(value: boolean) {
        this._validProprietaireNom = value;
    }
    get validBanqueLibelle(): boolean {
        return this._validBanqueLibelle;
    }
    set validBanqueLibelle(value: boolean) {
        this._validBanqueLibelle = value;
    }
    get validBanqueCode(): boolean {
        return this._validBanqueCode;
    }
    set validBanqueCode(value: boolean) {
        this._validBanqueCode = value;
    }
    get validCompteNumeroCompte(): boolean {
        return this._validCompteNumeroCompte;
    }
    set validCompteNumeroCompte(value: boolean) {
        this._validCompteNumeroCompte = value;
    }
    get validCompteBanque(): boolean {
        return this._validCompteBanque;
    }
    set validCompteBanque(value: boolean) {
        this._validCompteBanque = value;
    }
    get validCompteProprietaire(): boolean {
        return this._validCompteProprietaire;
    }
    set validCompteProprietaire(value: boolean) {
        this._validCompteProprietaire = value;
    }
}
