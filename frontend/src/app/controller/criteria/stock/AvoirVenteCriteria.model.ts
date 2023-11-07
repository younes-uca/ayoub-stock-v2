import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {VenteCriteria} from './VenteCriteria.model';
import {AvoirVenteItemCriteria} from './AvoirVenteItemCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';

export class AvoirVenteCriteria  extends BaseCriteria  {

    public id: number;
    public dateAvoir: Date;
    public dateAvoirFrom: Date;
    public dateAvoirTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
      public avoirVenteItems: Array<AvoirVenteItemCriteria>;

}
