import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VenteDto} from './Vente.model';
import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from './Produit.model';

export class VenteItemDto extends BaseDto{

    public barCode: string;

    public quantite: null | number;

    public quantiteAvoir: null | number;

    public quantiteVendue: null | number;

    public remise: null | number;

    public prixUttc: null | number;

    public prixUht: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public produit: ProduitDto ;
    public vente: VenteDto ;
    public depot: DepotDto ;
    

    constructor() {
        super();

        this.barCode = '';
        this.quantite = null;
        this.quantiteAvoir = null;
        this.quantiteVendue = null;
        this.remise = null;
        this.prixUttc = null;
        this.prixUht = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.produit = new ProduitDto() ;
        this.vente = new VenteDto() ;
        this.depot = new DepotDto() ;

        }

}
