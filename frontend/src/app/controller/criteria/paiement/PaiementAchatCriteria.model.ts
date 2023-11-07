import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {AchatCriteria} from '../stock/AchatCriteria.model';
import {ModePaiementCriteria} from '../commun/ModePaiementCriteria.model';

export class PaiementAchatCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;
  public achat: AchatCriteria ;
  public achats: Array<AchatCriteria> ;
  public modePaiement: ModePaiementCriteria ;
  public modePaiements: Array<ModePaiementCriteria> ;

}
