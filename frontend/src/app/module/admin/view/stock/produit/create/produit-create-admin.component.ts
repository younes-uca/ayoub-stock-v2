import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';
import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockAdminService} from 'src/app/controller/service/admin/stock/StockAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
@Component({
  selector: 'app-produit-create-admin',
  templateUrl: './produit-create-admin.component.html'
})
export class ProduitCreateAdminComponent extends AbstractCreateController<ProduitDto, ProduitCriteria, ProduitAdminService>  implements OnInit {

    private _stocksElement = new StockDto();


   private _validProduitEntrepriseSociete = true;
   private _validProduitReference = true;
   private _validProduitBarCode = true;
   private _validProduitCategorie = true;
   private _validProduitDesignation = true;
   private _validProduitMarque = true;
   private _validProduitUniteMesure = true;
   private _validProduitQuantite = true;
   private _validProduitStocks = true;
    private _validEntrepriseSocieteNom = true;
    private _validCategorieLibelle = true;
    private _validCategorieCode = true;
    private _validMarqueLibelle = true;
    private _validMarqueCode = true;
    private _validUniteMesureLibelle = true;
    private _validUniteMesureCode = true;
    private _validStocksProduit = true;
    private _validStocksDepot = true;
    private _validStocksQuantite = true;

    constructor( private produitService: ProduitAdminService , private stockService: StockAdminService, private depotService: DepotAdminService, private marqueService: MarqueAdminService, private uniteMesureService: UniteMesureAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private categorieService: CategorieAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.stocksElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.categorie = new CategorieDto();
        this.categorieService.findAll().subscribe((data) => this.categories = data);
        this.marque = new MarqueDto();
        this.marqueService.findAll().subscribe((data) => this.marques = data);
        this.uniteMesure = new UniteMesureDto();
        this.uniteMesureService.findAll().subscribe((data) => this.uniteMesures = data);
    }



    validateStocks(){
        this.errorMessages = new Array();
        this.validateStocksProduit();
        this.validateStocksDepot();
        this.validateStocksQuantite();
    }


    public setValidation(value: boolean){
        this.validProduitEntrepriseSociete = value;
        this.validProduitReference = value;
        this.validProduitBarCode = value;
        this.validProduitCategorie = value;
        this.validProduitDesignation = value;
        this.validProduitMarque = value;
        this.validProduitUniteMesure = value;
        this.validProduitQuantite = value;
        this.validProduitStocks = value;
        this.validStocksProduit = value;
        this.validStocksDepot = value;
        this.validStocksQuantite = value;
    }

    public addStocks() {
        if( this.item.stocks == null )
            this.item.stocks = new Array<StockDto>();
       this.validateStocks();
       if (this.errorMessages.length === 0) {
              this.item.stocks.push({... this.stocksElement});
              this.stocksElement = new StockDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletestocks(p: StockDto) {
        this.item.stocks.forEach((element, index) => {
            if (element === p) { this.item.stocks.splice(index, 1); }
        });
    }

    public editstocks(p: StockDto) {
        this.stocksElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitEntrepriseSociete();
        this.validateProduitReference();
        this.validateProduitBarCode();
        this.validateProduitCategorie();
        this.validateProduitDesignation();
        this.validateProduitMarque();
        this.validateProduitUniteMesure();
        this.validateProduitQuantite();
        this.validateProduitStocks();
    }

    public validateProduitEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
        this.errorMessages.push('Entreprise societe non valide');
        this.validProduitEntrepriseSociete = false;
        } else {
            this.validProduitEntrepriseSociete = true;
        }
    }
    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }
    public validateProduitBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validProduitBarCode = false;
        } else {
            this.validProduitBarCode = true;
        }
    }
    public validateProduitCategorie(){
        if (this.stringUtilService.isEmpty(this.item.categorie)) {
        this.errorMessages.push('Categorie non valide');
        this.validProduitCategorie = false;
        } else {
            this.validProduitCategorie = true;
        }
    }
    public validateProduitDesignation(){
        if (this.stringUtilService.isEmpty(this.item.designation)) {
        this.errorMessages.push('Designation non valide');
        this.validProduitDesignation = false;
        } else {
            this.validProduitDesignation = true;
        }
    }
    public validateProduitMarque(){
        if (this.stringUtilService.isEmpty(this.item.marque)) {
        this.errorMessages.push('Marque non valide');
        this.validProduitMarque = false;
        } else {
            this.validProduitMarque = true;
        }
    }
    public validateProduitUniteMesure(){
        if (this.stringUtilService.isEmpty(this.item.uniteMesure)) {
        this.errorMessages.push('Unite mesure non valide');
        this.validProduitUniteMesure = false;
        } else {
            this.validProduitUniteMesure = true;
        }
    }
    public validateProduitQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validProduitQuantite = false;
        } else {
            this.validProduitQuantite = true;
        }
    }
    public validateProduitStocks(){
        if (this.stringUtilService.isEmpty(this.item.stocks)) {
        this.errorMessages.push('Stocks non valide');
        this.validProduitStocks = false;
        } else {
            this.validProduitStocks = true;
        }
    }

    public validateStocksProduit(){
        if (this.stocksElement.produit == null) {
            this.errorMessages.push('Produit de la stock est  invalide');
            this.validStocksProduit = false;
        } else {
            this.validStocksProduit = true;
        }
    }
    public validateStocksDepot(){
        if (this.stocksElement.depot == null) {
            this.errorMessages.push('Depot de la stock est  invalide');
            this.validStocksDepot = false;
        } else {
            this.validStocksDepot = true;
        }
    }
    public validateStocksQuantite(){
        if (this.stocksElement.quantite == null) {
            this.errorMessages.push('Quantite de la stock est  invalide');
            this.validStocksQuantite = false;
        } else {
            this.validStocksQuantite = true;
        }
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
    get marque(): MarqueDto {
        return this.marqueService.item;
    }
    set marque(value: MarqueDto) {
        this.marqueService.item = value;
    }
    get marques(): Array<MarqueDto> {
        return this.marqueService.items;
    }
    set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
    }
    get createMarqueDialog(): boolean {
       return this.marqueService.createDialog;
    }
    set createMarqueDialog(value: boolean) {
        this.marqueService.createDialog= value;
    }
    get uniteMesure(): UniteMesureDto {
        return this.uniteMesureService.item;
    }
    set uniteMesure(value: UniteMesureDto) {
        this.uniteMesureService.item = value;
    }
    get uniteMesures(): Array<UniteMesureDto> {
        return this.uniteMesureService.items;
    }
    set uniteMesures(value: Array<UniteMesureDto>) {
        this.uniteMesureService.items = value;
    }
    get createUniteMesureDialog(): boolean {
       return this.uniteMesureService.createDialog;
    }
    set createUniteMesureDialog(value: boolean) {
        this.uniteMesureService.createDialog= value;
    }
    get entrepriseSociete(): EntrepriseSocieteDto {
        return this.entrepriseSocieteService.item;
    }
    set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
    }
    get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
        return this.entrepriseSocieteService.items;
    }
    set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
    }
    get createEntrepriseSocieteDialog(): boolean {
       return this.entrepriseSocieteService.createDialog;
    }
    set createEntrepriseSocieteDialog(value: boolean) {
        this.entrepriseSocieteService.createDialog= value;
    }
    get categorie(): CategorieDto {
        return this.categorieService.item;
    }
    set categorie(value: CategorieDto) {
        this.categorieService.item = value;
    }
    get categories(): Array<CategorieDto> {
        return this.categorieService.items;
    }
    set categories(value: Array<CategorieDto>) {
        this.categorieService.items = value;
    }
    get createCategorieDialog(): boolean {
       return this.categorieService.createDialog;
    }
    set createCategorieDialog(value: boolean) {
        this.categorieService.createDialog= value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validCategorieLibelle(): boolean {
        return this._validCategorieLibelle;
    }
    set validCategorieLibelle(value: boolean) {
        this._validCategorieLibelle = value;
    }
    get validCategorieCode(): boolean {
        return this._validCategorieCode;
    }
    set validCategorieCode(value: boolean) {
        this._validCategorieCode = value;
    }
    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }
    set validMarqueLibelle(value: boolean) {
        this._validMarqueLibelle = value;
    }
    get validMarqueCode(): boolean {
        return this._validMarqueCode;
    }
    set validMarqueCode(value: boolean) {
        this._validMarqueCode = value;
    }
    get validUniteMesureLibelle(): boolean {
        return this._validUniteMesureLibelle;
    }
    set validUniteMesureLibelle(value: boolean) {
        this._validUniteMesureLibelle = value;
    }
    get validUniteMesureCode(): boolean {
        return this._validUniteMesureCode;
    }
    set validUniteMesureCode(value: boolean) {
        this._validUniteMesureCode = value;
    }
    get validStocksProduit(): boolean {
        return this._validStocksProduit;
    }
    set validStocksProduit(value: boolean) {
        this._validStocksProduit = value;
    }
    get validStocksDepot(): boolean {
        return this._validStocksDepot;
    }
    set validStocksDepot(value: boolean) {
        this._validStocksDepot = value;
    }
    get validStocksQuantite(): boolean {
        return this._validStocksQuantite;
    }
    set validStocksQuantite(value: boolean) {
        this._validStocksQuantite = value;
    }

    get stocksElement(): StockDto {
        if( this._stocksElement == null )
            this._stocksElement = new StockDto();
        return this._stocksElement;
    }

    set stocksElement(value: StockDto) {
        this._stocksElement = value;
    }

}
