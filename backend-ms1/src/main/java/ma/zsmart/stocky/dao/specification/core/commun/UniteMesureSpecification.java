package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zsmart.stocky.bean.core.commun.UniteMesure;


public class UniteMesureSpecification extends  AbstractSpecification<UniteMesureCriteria, UniteMesure>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria) {
        super(criteria);
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
