import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementAvoirVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementAvoirVenteAdmin.service';
import {PaiementAvoirVenteDto} from 'src/app/controller/model/paiement/PaiementAvoirVente.model';
import {PaiementAvoirVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirVenteCriteria.model';


import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';

@Component({
  selector: 'app-paiement-avoir-vente-edit-admin',
  templateUrl: './paiement-avoir-vente-edit-admin.component.html'
})
export class PaiementAvoirVenteEditAdminComponent extends AbstractEditController<PaiementAvoirVenteDto, PaiementAvoirVenteCriteria, PaiementAvoirVenteAdminService>   implements OnInit {


    private _validPaiementAvoirVenteReference = true;
    private _validPaiementAvoirVenteDatePaiement = true;
    private _validPaiementAvoirVenteMontant = true;
    private _validPaiementAvoirVenteVente = true;
    private _validPaiementAvoirVenteModePaiement = true;
    private _validPaiementAvoirVenteAvoirVente = true;

    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteClient = true;
    private _validVenteMontantTtc = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteDateAvoir = true;
    private _validAvoirVenteMontant = true;
    private _validAvoirVenteVente = true;



    constructor( private paiementAvoirVenteService: PaiementAvoirVenteAdminService , private venteService: VenteAdminService, private avoirVenteService: AvoirVenteAdminService, private modePaiementService: ModePaiementAdminService) {
        super(paiementAvoirVenteService);
    }

    ngOnInit(): void {
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.avoirVente = new AvoirVenteDto();
        this.avoirVenteService.findAll().subscribe((data) => this.avoirVentes = data);
    }
    public prepareEdit() {
        this.item.datePaiement = this.paiementAvoirVenteService.format(this.item.datePaiement);
    }



    public setValidation(value: boolean){
        this.validPaiementAvoirVenteReference = value;
        this.validPaiementAvoirVenteDatePaiement = value;
        this.validPaiementAvoirVenteMontant = value;
        this.validPaiementAvoirVenteVente = value;
        this.validPaiementAvoirVenteModePaiement = value;
        this.validPaiementAvoirVenteAvoirVente = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementAvoirVenteReference();
        this.validatePaiementAvoirVenteDatePaiement();
        this.validatePaiementAvoirVenteMontant();
        this.validatePaiementAvoirVenteVente();
        this.validatePaiementAvoirVenteModePaiement();
        this.validatePaiementAvoirVenteAvoirVente();
    }
    public validatePaiementAvoirVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementAvoirVenteReference = false;
        } else {
            this.validPaiementAvoirVenteReference = true;
        }
    }
    public validatePaiementAvoirVenteDatePaiement(){
        if (this.stringUtilService.isEmpty(this.item.datePaiement)) {
            this.errorMessages.push('Date paiement non valide');
            this.validPaiementAvoirVenteDatePaiement = false;
        } else {
            this.validPaiementAvoirVenteDatePaiement = true;
        }
    }
    public validatePaiementAvoirVenteMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validPaiementAvoirVenteMontant = false;
        } else {
            this.validPaiementAvoirVenteMontant = true;
        }
    }
    public validatePaiementAvoirVenteVente(){
        if (this.stringUtilService.isEmpty(this.item.vente)) {
            this.errorMessages.push('Vente non valide');
            this.validPaiementAvoirVenteVente = false;
        } else {
            this.validPaiementAvoirVenteVente = true;
        }
    }
    public validatePaiementAvoirVenteModePaiement(){
        if (this.stringUtilService.isEmpty(this.item.modePaiement)) {
            this.errorMessages.push('Mode paiement non valide');
            this.validPaiementAvoirVenteModePaiement = false;
        } else {
            this.validPaiementAvoirVenteModePaiement = true;
        }
    }
    public validatePaiementAvoirVenteAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.avoirVente)) {
            this.errorMessages.push('Avoir vente non valide');
            this.validPaiementAvoirVenteAvoirVente = false;
        } else {
            this.validPaiementAvoirVenteAvoirVente = true;
        }
    }




   get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
   }
  set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
   }
   get avoirVentes(): Array<AvoirVenteDto> {
        return this.avoirVenteService.items;
   }
   set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
   }
   get createAvoirVenteDialog(): boolean {
       return this.avoirVenteService.createDialog;
   }
  set createAvoirVenteDialog(value: boolean) {
       this.avoirVenteService.createDialog= value;
   }
   get vente(): VenteDto {
       return this.venteService.item;
   }
  set vente(value: VenteDto) {
        this.venteService.item = value;
   }
   get ventes(): Array<VenteDto> {
        return this.venteService.items;
   }
   set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
   }
   get createVenteDialog(): boolean {
       return this.venteService.createDialog;
   }
  set createVenteDialog(value: boolean) {
       this.venteService.createDialog= value;
   }
   get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
   }
  set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
   }
   get modePaiements(): Array<ModePaiementDto> {
        return this.modePaiementService.items;
   }
   set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
   }
   get createModePaiementDialog(): boolean {
       return this.modePaiementService.createDialog;
   }
  set createModePaiementDialog(value: boolean) {
       this.modePaiementService.createDialog= value;
   }


    get validPaiementAvoirVenteReference(): boolean {
        return this._validPaiementAvoirVenteReference;
    }
    set validPaiementAvoirVenteReference(value: boolean) {
        this._validPaiementAvoirVenteReference = value;
    }
    get validPaiementAvoirVenteDatePaiement(): boolean {
        return this._validPaiementAvoirVenteDatePaiement;
    }
    set validPaiementAvoirVenteDatePaiement(value: boolean) {
        this._validPaiementAvoirVenteDatePaiement = value;
    }
    get validPaiementAvoirVenteMontant(): boolean {
        return this._validPaiementAvoirVenteMontant;
    }
    set validPaiementAvoirVenteMontant(value: boolean) {
        this._validPaiementAvoirVenteMontant = value;
    }
    get validPaiementAvoirVenteVente(): boolean {
        return this._validPaiementAvoirVenteVente;
    }
    set validPaiementAvoirVenteVente(value: boolean) {
        this._validPaiementAvoirVenteVente = value;
    }
    get validPaiementAvoirVenteModePaiement(): boolean {
        return this._validPaiementAvoirVenteModePaiement;
    }
    set validPaiementAvoirVenteModePaiement(value: boolean) {
        this._validPaiementAvoirVenteModePaiement = value;
    }
    get validPaiementAvoirVenteAvoirVente(): boolean {
        return this._validPaiementAvoirVenteAvoirVente;
    }
    set validPaiementAvoirVenteAvoirVente(value: boolean) {
        this._validPaiementAvoirVenteAvoirVente = value;
    }

    get validVenteEntrepriseSociete(): boolean {
        return this._validVenteEntrepriseSociete;
    }
    set validVenteEntrepriseSociete(value: boolean) {
        this._validVenteEntrepriseSociete = value;
    }
    get validVenteCodeVente(): boolean {
        return this._validVenteCodeVente;
    }
    set validVenteCodeVente(value: boolean) {
        this._validVenteCodeVente = value;
    }
    get validVenteClient(): boolean {
        return this._validVenteClient;
    }
    set validVenteClient(value: boolean) {
        this._validVenteClient = value;
    }
    get validVenteMontantTtc(): boolean {
        return this._validVenteMontantTtc;
    }
    set validVenteMontantTtc(value: boolean) {
        this._validVenteMontantTtc = value;
    }
    get validModePaiementLibelle(): boolean {
        return this._validModePaiementLibelle;
    }
    set validModePaiementLibelle(value: boolean) {
        this._validModePaiementLibelle = value;
    }
    get validModePaiementCode(): boolean {
        return this._validModePaiementCode;
    }
    set validModePaiementCode(value: boolean) {
        this._validModePaiementCode = value;
    }
    get validAvoirVenteEntrepriseSociete(): boolean {
        return this._validAvoirVenteEntrepriseSociete;
    }
    set validAvoirVenteEntrepriseSociete(value: boolean) {
        this._validAvoirVenteEntrepriseSociete = value;
    }
    get validAvoirVenteDateAvoir(): boolean {
        return this._validAvoirVenteDateAvoir;
    }
    set validAvoirVenteDateAvoir(value: boolean) {
        this._validAvoirVenteDateAvoir = value;
    }
    get validAvoirVenteMontant(): boolean {
        return this._validAvoirVenteMontant;
    }
    set validAvoirVenteMontant(value: boolean) {
        this._validAvoirVenteMontant = value;
    }
    get validAvoirVenteVente(): boolean {
        return this._validAvoirVenteVente;
    }
    set validAvoirVenteVente(value: boolean) {
        this._validAvoirVenteVente = value;
    }
}
