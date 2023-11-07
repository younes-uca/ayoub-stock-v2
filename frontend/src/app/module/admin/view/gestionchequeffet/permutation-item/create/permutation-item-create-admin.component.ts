import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationItemCriteria.model';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
@Component({
  selector: 'app-permutation-item-create-admin',
  templateUrl: './permutation-item-create-admin.component.html'
})
export class PermutationItemCreateAdminComponent extends AbstractCreateController<PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService>  implements OnInit {



   private _validPermutationItemProduit = true;
   private _validPermutationItemQuantite = true;
   private _validPermutationItemDepotOrigine = true;
   private _validPermutationItemDepotDestination = true;
    private _validProduitEntrepriseSociete = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitMarque = true;
    private _validProduitUniteMesure = true;
    private _validProduitQuantite = true;
    private _validProduitStocks = true;
    private _validDepotOrigineLibelle = true;
    private _validDepotOrigineCode = true;
    private _validDepotDestinationLibelle = true;
    private _validDepotDestinationCode = true;
    private _validPermutationDatePermutation = true;

    constructor( private permutationItemService: PermutationItemAdminService , private permutationService: PermutationAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService) {
        super(permutationItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depotOrigine = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depotOrigines = data);
        this.depotDestination = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depotDestinations = data);
        this.permutation = new PermutationDto();
        this.permutationService.findAll().subscribe((data) => this.permutations = data);
    }





    public setValidation(value: boolean){
        this.validPermutationItemProduit = value;
        this.validPermutationItemQuantite = value;
        this.validPermutationItemDepotOrigine = value;
        this.validPermutationItemDepotDestination = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePermutationItemProduit();
        this.validatePermutationItemQuantite();
        this.validatePermutationItemDepotOrigine();
        this.validatePermutationItemDepotDestination();
    }

    public validatePermutationItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validPermutationItemProduit = false;
        } else {
            this.validPermutationItemProduit = true;
        }
    }
    public validatePermutationItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validPermutationItemQuantite = false;
        } else {
            this.validPermutationItemQuantite = true;
        }
    }
    public validatePermutationItemDepotOrigine(){
        if (this.stringUtilService.isEmpty(this.item.depotOrigine)) {
        this.errorMessages.push('Depot origine non valide');
        this.validPermutationItemDepotOrigine = false;
        } else {
            this.validPermutationItemDepotOrigine = true;
        }
    }
    public validatePermutationItemDepotDestination(){
        if (this.stringUtilService.isEmpty(this.item.depotDestination)) {
        this.errorMessages.push('Depot destination non valide');
        this.validPermutationItemDepotDestination = false;
        } else {
            this.validPermutationItemDepotDestination = true;
        }
    }


    public async openCreatePermutation(permutation: string) {
    const isPermistted = await this.roleService.isPermitted('Permutation', 'add');
    if(isPermistted) {
         this.permutation = new PermutationDto();
         this.createPermutationDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get depotDestination(): DepotDto {
        return this.depotService.item;
    }
    set depotDestination(value: DepotDto) {
        this.depotService.item = value;
    }
    get depotDestinations(): Array<DepotDto> {
        return this.depotService.items;
    }
    set depotDestinations(value: Array<DepotDto>) {
        this.depotService.items = value;
    }
    get createDepotDestinationDialog(): boolean {
       return this.depotService.createDialog;
    }
    set createDepotDestinationDialog(value: boolean) {
        this.depotService.createDialog= value;
    }
    get depotOrigine(): DepotDto {
        return this.depotService.item;
    }
    set depotOrigine(value: DepotDto) {
        this.depotService.item = value;
    }
    get depotOrigines(): Array<DepotDto> {
        return this.depotService.items;
    }
    set depotOrigines(value: Array<DepotDto>) {
        this.depotService.items = value;
    }
    get createDepotOrigineDialog(): boolean {
       return this.depotService.createDialog;
    }
    set createDepotOrigineDialog(value: boolean) {
        this.depotService.createDialog= value;
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
    get permutation(): PermutationDto {
        return this.permutationService.item;
    }
    set permutation(value: PermutationDto) {
        this.permutationService.item = value;
    }
    get permutations(): Array<PermutationDto> {
        return this.permutationService.items;
    }
    set permutations(value: Array<PermutationDto>) {
        this.permutationService.items = value;
    }
    get createPermutationDialog(): boolean {
       return this.permutationService.createDialog;
    }
    set createPermutationDialog(value: boolean) {
        this.permutationService.createDialog= value;
    }



    get validPermutationItemProduit(): boolean {
        return this._validPermutationItemProduit;
    }

    set validPermutationItemProduit(value: boolean) {
         this._validPermutationItemProduit = value;
    }
    get validPermutationItemQuantite(): boolean {
        return this._validPermutationItemQuantite;
    }

    set validPermutationItemQuantite(value: boolean) {
         this._validPermutationItemQuantite = value;
    }
    get validPermutationItemDepotOrigine(): boolean {
        return this._validPermutationItemDepotOrigine;
    }

    set validPermutationItemDepotOrigine(value: boolean) {
         this._validPermutationItemDepotOrigine = value;
    }
    get validPermutationItemDepotDestination(): boolean {
        return this._validPermutationItemDepotDestination;
    }

    set validPermutationItemDepotDestination(value: boolean) {
         this._validPermutationItemDepotDestination = value;
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
    get validDepotOrigineLibelle(): boolean {
        return this._validDepotOrigineLibelle;
    }
    set validDepotOrigineLibelle(value: boolean) {
        this._validDepotOrigineLibelle = value;
    }
    get validDepotOrigineCode(): boolean {
        return this._validDepotOrigineCode;
    }
    set validDepotOrigineCode(value: boolean) {
        this._validDepotOrigineCode = value;
    }
    get validDepotDestinationLibelle(): boolean {
        return this._validDepotDestinationLibelle;
    }
    set validDepotDestinationLibelle(value: boolean) {
        this._validDepotDestinationLibelle = value;
    }
    get validDepotDestinationCode(): boolean {
        return this._validDepotDestinationCode;
    }
    set validDepotDestinationCode(value: boolean) {
        this._validDepotDestinationCode = value;
    }
    get validPermutationDatePermutation(): boolean {
        return this._validPermutationDatePermutation;
    }
    set validPermutationDatePermutation(value: boolean) {
        this._validPermutationDatePermutation = value;
    }


}
