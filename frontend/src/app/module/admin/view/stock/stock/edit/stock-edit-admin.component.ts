import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StockAdminService} from 'src/app/controller/service/admin/stock/StockAdmin.service';
import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockCriteria} from 'src/app/controller/criteria/stock/StockCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';

@Component({
  selector: 'app-stock-edit-admin',
  templateUrl: './stock-edit-admin.component.html'
})
export class StockEditAdminComponent extends AbstractEditController<StockDto, StockCriteria, StockAdminService>   implements OnInit {


    private _validStockProduit = true;
    private _validStockDepot = true;
    private _validStockQuantite = true;

    private _validProduitEntrepriseSociete = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitMarque = true;
    private _validProduitUniteMesure = true;
    private _validProduitQuantite = true;
    private _validProduitStocks = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;



    constructor( private stockService: StockAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService) {
        super(stockService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }


    public setValidation(value: boolean){
        this.validStockProduit = value;
        this.validStockDepot = value;
        this.validStockQuantite = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStockProduit();
        this.validateStockDepot();
        this.validateStockQuantite();
    }
    public validateStockProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validStockProduit = false;
        } else {
            this.validStockProduit = true;
        }
    }
    public validateStockDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
            this.errorMessages.push('Depot non valide');
            this.validStockDepot = false;
        } else {
            this.validStockDepot = true;
        }
    }
    public validateStockQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validStockQuantite = false;
        } else {
            this.validStockQuantite = true;
        }
    }



   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get depot(): DepotDto {
       return this.depotService.item;
   }
  set depot(value: DepotDto) {
        this.depotService.item = value;
   }
   get depots(): Array<DepotDto> {
        return this.depotService.items;
   }
   set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
   }
   get createDepotDialog(): boolean {
       return this.depotService.createDialog;
   }
  set createDepotDialog(value: boolean) {
       this.depotService.createDialog= value;
   }


    get validStockProduit(): boolean {
        return this._validStockProduit;
    }
    set validStockProduit(value: boolean) {
        this._validStockProduit = value;
    }
    get validStockDepot(): boolean {
        return this._validStockDepot;
    }
    set validStockDepot(value: boolean) {
        this._validStockDepot = value;
    }
    get validStockQuantite(): boolean {
        return this._validStockQuantite;
    }
    set validStockQuantite(value: boolean) {
        this._validStockQuantite = value;
    }

    get validProduitEntrepriseSociete(): boolean {
        return this._validProduitEntrepriseSociete;
    }
    set validProduitEntrepriseSociete(value: boolean) {
        this._validProduitEntrepriseSociete = value;
    }
    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitBarCode(): boolean {
        return this._validProduitBarCode;
    }
    set validProduitBarCode(value: boolean) {
        this._validProduitBarCode = value;
    }
    get validProduitCategorie(): boolean {
        return this._validProduitCategorie;
    }
    set validProduitCategorie(value: boolean) {
        this._validProduitCategorie = value;
    }
    get validProduitDesignation(): boolean {
        return this._validProduitDesignation;
    }
    set validProduitDesignation(value: boolean) {
        this._validProduitDesignation = value;
    }
    get validProduitMarque(): boolean {
        return this._validProduitMarque;
    }
    set validProduitMarque(value: boolean) {
        this._validProduitMarque = value;
    }
    get validProduitUniteMesure(): boolean {
        return this._validProduitUniteMesure;
    }
    set validProduitUniteMesure(value: boolean) {
        this._validProduitUniteMesure = value;
    }
    get validProduitQuantite(): boolean {
        return this._validProduitQuantite;
    }
    set validProduitQuantite(value: boolean) {
        this._validProduitQuantite = value;
    }
    get validProduitStocks(): boolean {
        return this._validProduitStocks;
    }
    set validProduitStocks(value: boolean) {
        this._validProduitStocks = value;
    }
    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validDepotCode(): boolean {
        return this._validDepotCode;
    }
    set validDepotCode(value: boolean) {
        this._validDepotCode = value;
    }
}
