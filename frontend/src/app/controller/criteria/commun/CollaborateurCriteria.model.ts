import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class CollaborateurCriteria  extends BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;

}
