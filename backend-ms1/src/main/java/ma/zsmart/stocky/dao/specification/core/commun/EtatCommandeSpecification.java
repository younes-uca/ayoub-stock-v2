package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zsmart.stocky.bean.core.commun.EtatCommande;


public class EtatCommandeSpecification extends  AbstractSpecification<EtatCommandeCriteria, EtatCommande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria) {
        super(criteria);
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
