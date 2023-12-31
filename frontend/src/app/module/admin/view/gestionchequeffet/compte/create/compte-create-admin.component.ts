import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteCriteria} from 'src/app/controller/criteria/gestionchequeffet/CompteCriteria.model';
import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
@Component({
  selector: 'app-compte-create-admin',
  templateUrl: './compte-create-admin.component.html'
})
export class CompteCreateAdminComponent extends AbstractCreateController<CompteDto, CompteCriteria, CompteAdminService>  implements OnInit {



   private _validCompteNumeroCompte = true;
   private _validCompteBanque = true;
   private _validCompteProprietaire = true;
    private _validBanqueLibelle = true;
    private _validBanqueCode = true;
    private _validProprietaireNom = true;

    constructor( private compteService: CompteAdminService , private banqueService: BanqueAdminService, private proprietaireService: ProprietaireAdminService) {
        super(compteService);
    }

    ngOnInit(): void {
        this.banque = new BanqueDto();
        this.banqueService.findAll().subscribe((data) => this.banques = data);
        this.proprietaire = new ProprietaireDto();
        this.proprietaireService.findAll().subscribe((data) => this.proprietaires = data);
    }





    public setValidation(value: boolean){
        this.validCompteNumeroCompte = value;
        this.validCompteBanque = value;
        this.validCompteProprietaire = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCompteNumeroCompte();
        this.validateCompteBanque();
        this.validateCompteProprietaire();
    }

    public validateCompteNumeroCompte(){
        if (this.stringUtilService.isEmpty(this.item.numeroCompte)) {
        this.errorMessages.push('Numero compte non valide');
        this.validCompteNumeroCompte = false;
        } else {
            this.validCompteNumeroCompte = true;
        }
    }
    public validateCompteBanque(){
        if (this.stringUtilService.isEmpty(this.item.banque)) {
        this.errorMessages.push('Banque non valide');
        this.validCompteBanque = false;
        } else {
            this.validCompteBanque = true;
        }
    }
    public validateCompteProprietaire(){
        if (this.stringUtilService.isEmpty(this.item.proprietaire)) {
        this.errorMessages.push('Proprietaire non valide');
        this.validCompteProprietaire = false;
        } else {
            this.validCompteProprietaire = true;
        }
    }


    public async openCreateProprietaire(proprietaire: string) {
    const isPermistted = await this.roleService.isPermitted('Proprietaire', 'add');
    if(isPermistted) {
         this.proprietaire = new ProprietaireDto();
         this.createProprietaireDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateBanque(banque: string) {
    const isPermistted = await this.roleService.isPermitted('Banque', 'add');
    if(isPermistted) {
         this.banque = new BanqueDto();
         this.createBanqueDialog = true;
    }else{
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
    get validProprietaireNom(): boolean {
        return this._validProprietaireNom;
    }
    set validProprietaireNom(value: boolean) {
        this._validProprietaireNom = value;
    }


}
