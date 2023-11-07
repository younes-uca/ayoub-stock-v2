import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {PermutationCriteria} from './PermutationCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {ProduitCriteria} from '../stock/ProduitCriteria.model';

export class PermutationItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public depotOrigine: DepotCriteria ;
  public depotOrigines: Array<DepotCriteria> ;
  public depotDestination: DepotCriteria ;
  public depotDestinations: Array<DepotCriteria> ;
  public permutation: PermutationCriteria ;
  public permutations: Array<PermutationCriteria> ;

}
