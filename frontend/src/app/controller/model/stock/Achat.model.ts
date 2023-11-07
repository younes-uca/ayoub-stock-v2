import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AchatItemDto} from './AchatItem.model';
import {FournisseurDto} from '../commun/Fournisseur.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {EtatAchatDto} from '../commun/EtatAchat.model';
import {AvoirAchatDto} from './AvoirAchat.model';

export class AchatDto extends BaseDto{

   public dateFacture: Date;

    public montantHt: null | number;

    public tauxTva: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public fournisseur: FournisseurDto ;
    public etatAchat: EtatAchatDto ;
     public achatItems: Array<AchatItemDto>;
     public avoirs: Array<AvoirAchatDto>;
    

    constructor() {
        super();

        this.dateFacture = null;
        this.montantHt = null;
        this.tauxTva = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.fournisseur = new FournisseurDto() ;
        this.etatAchat = new EtatAchatDto() ;
        this.achatItems = new Array<AchatItemDto>();
        this.avoirs = new Array<AvoirAchatDto>();

        }

}
