package  ma.zsmart.stocky.dao.specification.core.stock;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.stock.InventaireCriteria;
import ma.zsmart.stocky.bean.core.stock.Inventaire;


public class InventaireSpecification extends  AbstractSpecification<InventaireCriteria, Inventaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateInventaire", criteria.getDateInventaire(), criteria.getDateInventaireFrom(), criteria.getDateInventaireTo());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
    }

    public InventaireSpecification(InventaireCriteria criteria) {
        super(criteria);
    }

    public InventaireSpecification(InventaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
