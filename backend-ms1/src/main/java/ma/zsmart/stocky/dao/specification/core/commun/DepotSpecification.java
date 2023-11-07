package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zsmart.stocky.bean.core.commun.Depot;


public class DepotSpecification extends  AbstractSpecification<DepotCriteria, Depot>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public DepotSpecification(DepotCriteria criteria) {
        super(criteria);
    }

    public DepotSpecification(DepotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
