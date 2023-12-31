import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-permutation-item-view-admin',
  templateUrl: './permutation-item-view-admin.component.html'
})
export class PermutationItemViewAdminComponent extends AbstractViewController<PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService> implements OnInit {


    constructor(private permutationItemService: PermutationItemAdminService, private permutationService: PermutationAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService){
        super(permutationItemService);
    }

    ngOnInit(): void {
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


}
