package  ma.zsmart.stocky.dao.specification.core.stock;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.stock.VenteItemCriteria;
import ma.zsmart.stocky.bean.core.stock.VenteItem;


public class VenteItemSpecification extends  AbstractSpecification<VenteItemCriteria, VenteItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("quantiteAvoir", criteria.getQuantiteAvoir(), criteria.getQuantiteAvoirMin(), criteria.getQuantiteAvoirMax());
        addPredicateBigDecimal("quantiteVendue", criteria.getQuantiteVendue(), criteria.getQuantiteVendueMin(), criteria.getQuantiteVendueMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateBigDecimal("prixUttc", criteria.getPrixUttc(), criteria.getPrixUttcMin(), criteria.getPrixUttcMax());
        addPredicateBigDecimal("prixUht", criteria.getPrixUht(), criteria.getPrixUhtMin(), criteria.getPrixUhtMax());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","code", criteria.getDepot()==null?null:criteria.getDepot().getCode());
    }

    public VenteItemSpecification(VenteItemCriteria criteria) {
        super(criteria);
    }

    public VenteItemSpecification(VenteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
