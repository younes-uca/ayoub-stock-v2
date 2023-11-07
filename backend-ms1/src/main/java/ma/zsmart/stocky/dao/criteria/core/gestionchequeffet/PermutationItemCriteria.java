package  ma.zsmart.stocky.dao.criteria.core.gestionchequeffet;


import ma.zsmart.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zsmart.stocky.dao.criteria.core.stock.ProduitCriteria;

import ma.zsmart.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PermutationItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private DepotCriteria depotOrigine ;
    private List<DepotCriteria> depotOrigines ;
    private DepotCriteria depotDestination ;
    private List<DepotCriteria> depotDestinations ;
    private PermutationCriteria permutation ;
    private List<PermutationCriteria> permutations ;


    public PermutationItemCriteria(){}

    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }   
    public String getQuantiteMin(){
        return this.quantiteMin;
    }
    public void setQuantiteMin(String quantiteMin){
        this.quantiteMin = quantiteMin;
    }
    public String getQuantiteMax(){
        return this.quantiteMax;
    }
    public void setQuantiteMax(String quantiteMax){
        this.quantiteMax = quantiteMax;
    }
      

    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public DepotCriteria getDepotOrigine(){
        return this.depotOrigine;
    }

    public void setDepotOrigine(DepotCriteria depotOrigine){
        this.depotOrigine = depotOrigine;
    }
    public List<DepotCriteria> getDepotOrigines(){
        return this.depotOrigines;
    }

    public void setDepotOrigines(List<DepotCriteria> depotOrigines){
        this.depotOrigines = depotOrigines;
    }
    public DepotCriteria getDepotDestination(){
        return this.depotDestination;
    }

    public void setDepotDestination(DepotCriteria depotDestination){
        this.depotDestination = depotDestination;
    }
    public List<DepotCriteria> getDepotDestinations(){
        return this.depotDestinations;
    }

    public void setDepotDestinations(List<DepotCriteria> depotDestinations){
        this.depotDestinations = depotDestinations;
    }
    public PermutationCriteria getPermutation(){
        return this.permutation;
    }

    public void setPermutation(PermutationCriteria permutation){
        this.permutation = permutation;
    }
    public List<PermutationCriteria> getPermutations(){
        return this.permutations;
    }

    public void setPermutations(List<PermutationCriteria> permutations){
        this.permutations = permutations;
    }
}
