import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {InventaireAdminService} from 'src/app/controller/service/admin/stock/InventaireAdmin.service';
import {InventaireDto} from 'src/app/controller/model/stock/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/stock/InventaireCriteria.model';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {InventaireItemDto} from 'src/app/controller/model/stock/InventaireItem.model';
import {InventaireItemAdminService} from 'src/app/controller/service/admin/stock/InventaireItemAdmin.service';
@Component({
  selector: 'app-inventaire-create-admin',
  templateUrl: './inventaire-create-admin.component.html'
})
export class InventaireCreateAdminComponent extends AbstractCreateController<InventaireDto, InventaireCriteria, InventaireAdminService>  implements OnInit {

    private _inventaireItemsElement = new InventaireItemDto();


   private _validInventaireEntrepriseSociete = true;
   private _validInventaireReference = true;
   private _validInventaireDateInventaire = true;
    private _validEntrepriseSocieteNom = true;
    private _validInventaireItemsProduit = true;
    private _validInventaireItemsQuantiteEstime = true;
    private _validInventaireItemsQuantiteReelle = true;
    private _validInventaireItemsInventaire = true;

    constructor( private inventaireService: InventaireAdminService , private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private inventaireItemService: InventaireItemAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.inventaireItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
    }



    validateInventaireItems(){
        this.errorMessages = new Array();
        this.validateInventaireItemsProduit();
        this.validateInventaireItemsQuantiteEstime();
        this.validateInventaireItemsQuantiteReelle();
        this.validateInventaireItemsInventaire();
    }


    public setValidation(value: boolean){
        this.validInventaireEntrepriseSociete = value;
        this.validInventaireReference = value;
        this.validInventaireDateInventaire = value;
        this.validInventaireItemsProduit = value;
        this.validInventaireItemsQuantiteEstime = value;
        this.validInventaireItemsQuantiteReelle = value;
        this.validInventaireItemsInventaire = value;
    }

    public addInventaireItems() {
        if( this.item.inventaireItems == null )
            this.item.inventaireItems = new Array<InventaireItemDto>();
       this.validateInventaireItems();
       if (this.errorMessages.length === 0) {
              this.item.inventaireItems.push({... this.inventaireItemsElement});
              this.inventaireItemsElement = new InventaireItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteinventaireItems(p: InventaireItemDto) {
        this.item.inventaireItems.forEach((element, index) => {
            if (element === p) { this.item.inventaireItems.splice(index, 1); }
        });
    }

    public editinventaireItems(p: InventaireItemDto) {
        this.inventaireItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInventaireEntrepriseSociete();
        this.validateInventaireReference();
        this.validateInventaireDateInventaire();
    }

    public validateInventaireEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
        this.errorMessages.push('Entreprise societe non valide');
        this.validInventaireEntrepriseSociete = false;
        } else {
            this.validInventaireEntrepriseSociete = true;
        }
    }
    public validateInventaireReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validInventaireReference = false;
        } else {
            this.validInventaireReference = true;
        }
    }
    public validateInventaireDateInventaire(){
        if (this.stringUtilService.isEmpty(this.item.dateInventaire)) {
        this.errorMessages.push('Date inventaire non valide');
        this.validInventaireDateInventaire = false;
        } else {
            this.validInventaireDateInventaire = true;
        }
    }

    public validateInventaireItemsProduit(){
        if (this.inventaireItemsElement.produit == null) {
            this.errorMessages.push('Produit de la inventaireItem est  invalide');
            this.validInventaireItemsProduit = false;
        } else {
            this.validInventaireItemsProduit = true;
        }
    }
    public validateInventaireItemsQuantiteEstime(){
        if (this.inventaireItemsElement.quantiteEstime == null) {
            this.errorMessages.push('QuantiteEstime de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteEstime = false;
        } else {
            this.validInventaireItemsQuantiteEstime = true;
        }
    }
    public validateInventaireItemsQuantiteReelle(){
        if (this.inventaireItemsElement.quantiteReelle == null) {
            this.errorMessages.push('QuantiteReelle de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteReelle = false;
        } else {
            this.validInventaireItemsQuantiteReelle = true;
        }
    }
    public validateInventaireItemsInventaire(){
        if (this.inventaireItemsElement.inventaire == null) {
            this.errorMessages.push('Inventaire de la inventaireItem est  invalide');
            this.validInventaireItemsInventaire = false;
        } else {
            this.validInventaireItemsInventaire = true;
        }
    }

    public async openCreateProduit(produit: string) {
    const isPermistted = await this.roleService.isPermitted('Produit', 'add');
    if(isPermistted) {
         this.produit = new ProduitDto();
         this.createProduitDialog = true;
    }else{
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



    get validInventaireEntrepriseSociete(): boolean {
        return this._validInventaireEntrepriseSociete;
    }

    set validInventaireEntrepriseSociete(value: boolean) {
         this._validInventaireEntrepriseSociete = value;
    }
    get validInventaireReference(): boolean {
        return this._validInventaireReference;
    }

    set validInventaireReference(value: boolean) {
         this._validInventaireReference = value;
    }
    get validInventaireDateInventaire(): boolean {
        return this._validInventaireDateInventaire;
    }

    set validInventaireDateInventaire(value: boolean) {
         this._validInventaireDateInventaire = value;
    }

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validInventaireItemsProduit(): boolean {
        return this._validInventaireItemsProduit;
    }
    set validInventaireItemsProduit(value: boolean) {
        this._validInventaireItemsProduit = value;
    }
    get validInventaireItemsQuantiteEstime(): boolean {
        return this._validInventaireItemsQuantiteEstime;
    }
    set validInventaireItemsQuantiteEstime(value: boolean) {
        this._validInventaireItemsQuantiteEstime = value;
    }
    get validInventaireItemsQuantiteReelle(): boolean {
        return this._validInventaireItemsQuantiteReelle;
    }
    set validInventaireItemsQuantiteReelle(value: boolean) {
        this._validInventaireItemsQuantiteReelle = value;
    }
    get validInventaireItemsInventaire(): boolean {
        return this._validInventaireItemsInventaire;
    }
    set validInventaireItemsInventaire(value: boolean) {
        this._validInventaireItemsInventaire = value;
    }

    get inventaireItemsElement(): InventaireItemDto {
        if( this._inventaireItemsElement == null )
            this._inventaireItemsElement = new InventaireItemDto();
        return this._inventaireItemsElement;
    }

    set inventaireItemsElement(value: InventaireItemDto) {
        this._inventaireItemsElement = value;
    }

}
