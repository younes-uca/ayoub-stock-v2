package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete;


public class EntrepriseSocieteSpecification extends  AbstractSpecification<EntrepriseSocieteCriteria, EntrepriseSociete>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicateBigDecimal("capital", criteria.getCapital(), criteria.getCapitalMin(), criteria.getCapitalMax());
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria) {
        super(criteria);
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
