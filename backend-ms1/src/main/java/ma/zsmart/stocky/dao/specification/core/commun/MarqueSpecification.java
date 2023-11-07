package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.MarqueCriteria;
import ma.zsmart.stocky.bean.core.commun.Marque;


public class MarqueSpecification extends  AbstractSpecification<MarqueCriteria, Marque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public MarqueSpecification(MarqueCriteria criteria) {
        super(criteria);
    }

    public MarqueSpecification(MarqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
