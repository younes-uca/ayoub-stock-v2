import {Component, OnInit} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {
    PermutationItemAdminService
} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';

@Component({
    selector: 'app-permutation-edit-admin',
    templateUrl: './permutation-edit-admin.component.html'
})
// tslint:disable-next-line:max-line-length
export class PermutationEditAdminComponent extends AbstractEditController<PermutationDto, PermutationCriteria, PermutationAdminService> implements OnInit {

    private _permutationItemsElement = new PermutationItemDto();

    private _validPermutationDatePermutation = true;

    private _validPermutationItemsProduit = true;
    private _validPermutationItemsQuantite = true;
    private _validPermutationItemsDepotOrigine = true;
    private _validPermutationItemsDepotDestination = true;


    // tslint:disable-next-line:max-line-length
    constructor(private permutationService: PermutationAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService, private permutationItemService: PermutationItemAdminService) {
        super(permutationService);
    }

    ngOnInit(): void {
        this.permutationItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.permutationItemsElement.depotOrigine = new DepotDto();
        this.permutationItemsElement.depotDestination = new DepotDto();

    }

    public prepareEdit() {
        this.item.datePermutation = this.permutationService.format(this.item.datePermutation);
    }


    public validatePermutationItems() {
        this.errorMessages = new Array();
        this.validatePermutationItemsProduit();
        this.validatePermutationItemsQuantite();
        this.validatePermutationItemsDepotOrigine();
        this.validatePermutationItemsDepotDestination();
    }

    public setValidation(value: boolean) {
        this.validPermutationDatePermutation = value;
        this.validPermutationItemsProduit = value;
        this.validPermutationItemsQuantite = value;
        this.validPermutationItemsDepotOrigine = value;
        this.validPermutationItemsDepotDestination = value;
    }

    public addPermutationItems() {

    }

    public deletePermutationItems(p: PermutationItemDto) {
        this.item.permutationItems.forEach((element, index) => {
            if (element === p) {
                this.item.permutationItems.splice(index, 1);
            }
        });
    }

    public editPermutationItems(p: PermutationItemDto) {
        this.permutationItemsElement = {...p};
        this.activeTab = 0;
    }

    public validateForm(): void {
        this.errorMessages = new Array<string>();
        this.validatePermutationDatePermutation();
    }

    public validatePermutationDatePermutation() {
        if (this.stringUtilService.isEmpty(this.item.datePermutation)) {
            this.errorMessages.push('Date permutation non valide');
            this.validPermutationDatePermutation = false;
        } else {
            this.validPermutationDatePermutation = true;
        }
    }


    private validatePermutationItemsProduit() {

    }

    private validatePermutationItemsQuantite() {
        if (this.permutationItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la permutationItem est  invalide');
            this.validPermutationItemsQuantite = false;
        } else {
            this.validPermutationItemsQuantite = true;
        }
    }

    private validatePermutationItemsDepotOrigine() {
        if (this.permutationItemsElement.depotOrigine == null) {
            this.errorMessages.push('DepotOrigine de la permutationItem est  invalide');
            this.validPermutationItemsDepotOrigine = false;
        } else {
            this.validPermutationItemsDepotOrigine = true;
        }
    }

    private validatePermutationItemsDepotDestination() {
        if (this.permutationItemsElement.depotDestination == null) {
            this.errorMessages.push('DepotDestination de la permutationItem est  invalide');
            this.validPermutationItemsDepotDestination = false;
        } else {
            this.validPermutationItemsDepotDestination = true;
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
        this.depotService.createDialog = value;
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
        this.depotService.createDialog = value;
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
        this.produitService.createDialog = value;
    }

    get permutationItemsElement(): PermutationItemDto {
        if (this._permutationItemsElement == null) {
            this._permutationItemsElement = new PermutationItemDto();
        }
        return this._permutationItemsElement;
    }

    set permutationItemsElement(value: PermutationItemDto) {
        this._permutationItemsElement = value;
    }

    get validPermutationDatePermutation(): boolean {
        return this._validPermutationDatePermutation;
    }

    set validPermutationDatePermutation(value: boolean) {
        this._validPermutationDatePermutation = value;
    }

    get validPermutationItemsProduit(): boolean {
        return this._validPermutationItemsProduit;
    }

    set validPermutationItemsProduit(value: boolean) {
        this._validPermutationItemsProduit = value;
    }

    get validPermutationItemsQuantite(): boolean {
        return this._validPermutationItemsQuantite;
    }

    set validPermutationItemsQuantite(value: boolean) {
        this._validPermutationItemsQuantite = value;
    }

    get validPermutationItemsDepotOrigine(): boolean {
        return this._validPermutationItemsDepotOrigine;
    }

    set validPermutationItemsDepotOrigine(value: boolean) {
        this._validPermutationItemsDepotOrigine = value;
    }

    get validPermutationItemsDepotDestination(): boolean {
        return this._validPermutationItemsDepotDestination;
    }

    set validPermutationItemsDepotDestination(value: boolean) {
        this._validPermutationItemsDepotDestination = value;
    }
}
