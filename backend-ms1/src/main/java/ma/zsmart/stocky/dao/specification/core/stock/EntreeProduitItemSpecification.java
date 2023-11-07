package  ma.zsmart.stocky.dao.specification.core.stock;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zsmart.stocky.bean.core.stock.EntreeProduitItem;


public class EntreeProduitItemSpecification extends  AbstractSpecification<EntreeProduitItemCriteria, EntreeProduitItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getId());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduits());
        addPredicateFk("entreeProduit","reference", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getReference());
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
