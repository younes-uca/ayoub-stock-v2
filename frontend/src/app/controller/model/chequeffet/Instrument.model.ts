import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeInstrumentDto} from '../gestionchequeffet/TypeInstrument.model';
import {ChequeEffetDto} from '../gestionchequeffet/ChequeEffet.model';

export class InstrumentDto extends BaseDto{

   public dateEmission: Date;

    public montant: null | number;

    public typeInstrument: TypeInstrumentDto ;
    public chequeEffet: ChequeEffetDto ;
    

    constructor() {
        super();

        this.dateEmission = null;
        this.montant = null;
        this.typeInstrument = new TypeInstrumentDto() ;
        this.chequeEffet = new ChequeEffetDto() ;

        }

}
