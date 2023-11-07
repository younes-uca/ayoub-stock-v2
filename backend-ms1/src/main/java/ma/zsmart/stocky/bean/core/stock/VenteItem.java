package ma.zsmart.stocky.bean.core.stock;

import java.util.Objects;





import ma.zsmart.stocky.bean.core.commun.Depot;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "vente_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_item_seq",sequenceName="vente_item_seq",allocationSize=1, initialValue = 1)
public class VenteItem   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal quantiteAvoir = BigDecimal.ZERO;
    private BigDecimal quantiteVendue = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;
    private BigDecimal prixUttc = BigDecimal.ZERO;
    private BigDecimal prixUht = BigDecimal.ZERO;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;

    private Produit produit ;
    private Vente vente ;
    private Depot depot ;


    public VenteItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="vente_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }
    public BigDecimal getQuantiteVendue(){
        return this.quantiteVendue;
    }
    public void setQuantiteVendue(BigDecimal quantiteVendue){
        this.quantiteVendue = quantiteVendue;
    }
    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }
    public BigDecimal getPrixUttc(){
        return this.prixUttc;
    }
    public void setPrixUttc(BigDecimal prixUttc){
        this.prixUttc = prixUttc;
    }
    public BigDecimal getPrixUht(){
        return this.prixUht;
    }
    public void setPrixUht(BigDecimal prixUht){
        this.prixUht = prixUht;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenteItem venteItem = (VenteItem) o;
        return id != null && id.equals(venteItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

