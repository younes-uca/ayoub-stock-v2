package  ma.zsmart.stocky.dao.specification.core.stock;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zsmart.stocky.bean.core.stock.CommandeItem;


public class CommandeItemSpecification extends  AbstractSpecification<CommandeItemCriteria, CommandeItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("commande","id", criteria.getCommande()==null?null:criteria.getCommande().getId());
        addPredicateFk("commande","id", criteria.getCommandes());
    }

    public CommandeItemSpecification(CommandeItemCriteria criteria) {
        super(criteria);
    }

    public CommandeItemSpecification(CommandeItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
