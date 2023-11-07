import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {VenteCriteria} from './VenteCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';

export class VenteItemCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public quantiteAvoir: number;
     public quantiteAvoirMin: number;
     public quantiteAvoirMax: number;
     public quantiteVendue: number;
     public quantiteVendueMin: number;
     public quantiteVendueMax: number;
     public remise: number;
     public remiseMin: number;
     public remiseMax: number;
     public prixUttc: number;
     public prixUttcMin: number;
     public prixUttcMax: number;
     public prixUht: number;
     public prixUhtMin: number;
     public prixUhtMax: number;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;

}
