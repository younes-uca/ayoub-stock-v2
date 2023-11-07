package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zsmart.stocky.bean.core.commun.Fournisseur;


public class FournisseurSpecification extends  AbstractSpecification<FournisseurCriteria, Fournisseur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicate("telephone", criteria.getTelephone(),criteria.getTelephoneLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
        addPredicateBigDecimal("creance", criteria.getCreance(), criteria.getCreanceMin(), criteria.getCreanceMax());
        addPredicateFk("ville","id", criteria.getVille()==null?null:criteria.getVille().getId());
        addPredicateFk("ville","id", criteria.getVilles());
    }

    public FournisseurSpecification(FournisseurCriteria criteria) {
        super(criteria);
    }

    public FournisseurSpecification(FournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
