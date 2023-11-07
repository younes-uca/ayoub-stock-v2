package  ma.zsmart.stocky.ws.dto.stock;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zsmart.stocky.ws.dto.commun.DepotDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatItemDto  extends AuditBaseDto {

    private String barCode  ;
    private String footerBarCode  ;
    private BigDecimal quantite  ;
    private BigDecimal quantiteAvoir  ;
    private BigDecimal quantiteDisponible  ;
    private BigDecimal remise  ;
    private BigDecimal prixUttc  ;
    private BigDecimal prixUht  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTtc  ;

    private ProduitDto produit ;
    private AchatDto achat ;
    private DepotDto depot ;



    public AchatItemDto(){
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
    public String getFooterBarCode(){
        return this.footerBarCode;
    }
    public void setFooterBarCode(String footerBarCode){
        this.footerBarCode = footerBarCode;
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
    public BigDecimal getQuantiteDisponible(){
        return this.quantiteDisponible;
    }
    public void setQuantiteDisponible(BigDecimal quantiteDisponible){
        this.quantiteDisponible = quantiteDisponible;
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
    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }
    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }






}
