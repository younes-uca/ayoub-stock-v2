package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zsmart.stocky.bean.core.commun.EtatVente;


public class EtatVenteSpecification extends  AbstractSpecification<EtatVenteCriteria, EtatVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria) {
        super(criteria);
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
