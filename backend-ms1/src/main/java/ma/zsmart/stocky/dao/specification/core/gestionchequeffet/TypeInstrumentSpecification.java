package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeInstrument;


public class TypeInstrumentSpecification extends  AbstractSpecification<TypeInstrumentCriteria, TypeInstrument>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria) {
        super(criteria);
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
