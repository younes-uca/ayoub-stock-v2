import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PermutationDto} from './Permutation.model';
import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from '../stock/Produit.model';

export class PermutationItemDto extends BaseDto{

    public quantite: null | number;

    public produit: ProduitDto ;
    public depotOrigine: DepotDto ;
    public depotDestination: DepotDto ;
    public permutation: PermutationDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.produit = new ProduitDto() ;
        this.depotOrigine = new DepotDto() ;
        this.depotDestination = new DepotDto() ;
        this.permutation = new PermutationDto() ;

        }

}
