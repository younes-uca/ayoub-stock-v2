import {Component, OnInit} from '@angular/core';
import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-permutation-item-list-admin',
  templateUrl: './permutation-item-list-admin.component.html'
})
export class PermutationItemListAdminComponent extends AbstractListController<PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService>  implements OnInit {

    fileName = 'PermutationItem';

    produits: Array<ProduitDto>;
    depotOrigines: Array<DepotDto>;
    depotDestinations: Array<DepotDto>;
    permutations: Array<PermutationDto>;


    constructor( private permutationItemService: PermutationItemAdminService  , private permutationService: PermutationAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService) {
        super(permutationItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadDepotOrigine();
        this.loadDepotDestination();
        this.loadPermutation();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'depotOrigine?.libelle', header: 'Depot origine'},
            {field: 'depotDestination?.libelle', header: 'Depot destination'},
            {field: 'permutation?.id', header: 'Permutation'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadDepotOrigine(){
       this.depotService.findAllOptimized().subscribe(depotOrigines => this.depotOrigines = depotOrigines, error => console.log(error))
    }
    public async loadDepotDestination(){
       this.depotService.findAllOptimized().subscribe(depotDestinations => this.depotDestinations = depotDestinations, error => console.log(error))
    }
    public async loadPermutation(){
       this.permutationService.findAll().subscribe(permutations => this.permutations = permutations, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                'Depot origine': e.depotOrigine?.libelle ,
                'Depot destination': e.depotDestination?.libelle ,
                'Permutation': e.permutation?.id ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Depot origine': this.criteria.depotOrigine?.libelle ? this.criteria.depotOrigine?.libelle : environment.emptyForExport ,
        //'Depot destination': this.criteria.depotDestination?.libelle ? this.criteria.depotDestination?.libelle : environment.emptyForExport ,
        //'Permutation': this.criteria.permutation?.id ? this.criteria.permutation?.id : environment.emptyForExport ,
        }];
      }
}
