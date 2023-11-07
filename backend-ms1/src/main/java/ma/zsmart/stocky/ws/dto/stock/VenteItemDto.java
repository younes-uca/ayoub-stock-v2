package  ma.zsmart.stocky.ws.dto.stock;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zsmart.stocky.ws.dto.commun.DepotDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteItemDto  extends AuditBaseDto {

    private String barCode  ;
    private BigDecimal quantite  ;
    private BigDecimal quantiteAvoir  ;
    private BigDecimal quantiteVendue  ;
    private BigDecimal remise  ;
    private BigDecimal prixUttc  ;
    private BigDecimal prixUht  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTtc  ;

    private ProduitDto produit ;
    private VenteDto vente ;
    private DepotDto depot ;



    public VenteItemDto(){
        super();
    }



    @Log
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }

    @Log
    public BigDecimal getQuantiteVendue(){
        return this.quantiteVendue;
    }
    public void setQuantiteVendue(BigDecimal quantiteVendue){
        this.quantiteVendue = quantiteVendue;
    }

    @Log
    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }

    @Log
    public BigDecimal getPrixUttc(){
        return this.prixUttc;
    }
    public void setPrixUttc(BigDecimal prixUttc){
        this.prixUttc = prixUttc;
    }

    @Log
    public BigDecimal getPrixUht(){
        return this.prixUht;
    }
    public void setPrixUht(BigDecimal prixUht){
        this.prixUht = prixUht;
    }

    @Log
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }

    @Log
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }
    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }






}
