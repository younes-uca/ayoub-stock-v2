package  ma.zsmart.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.stocky.ws.converter.commun.DepotConverter;
import ma.zsmart.stocky.ws.converter.stock.ProduitConverter;
import ma.zsmart.stocky.ws.converter.stock.AvoirVenteConverter;

import ma.zsmart.stocky.bean.core.stock.Produit;
import ma.zsmart.stocky.bean.core.stock.AvoirVente;


import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.stock.AvoirVenteItem;
import ma.zsmart.stocky.ws.dto.stock.AvoirVenteItemDto;

@Component
public class AvoirVenteItemConverter extends AbstractConverter<AvoirVenteItem, AvoirVenteItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    private boolean produit;
    private boolean depot;
    private boolean avoirVente;

    public  AvoirVenteItemConverter(){
        super(AvoirVenteItem.class, AvoirVenteItemDto.class);
    }

    @Override
    public AvoirVenteItem toItem(AvoirVenteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVenteItem item = new AvoirVenteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontantAvoir()))
                item.setMontantAvoir(dto.getMontantAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getAvoirVente() != null && dto.getAvoirVente().getId() != null){
                item.setAvoirVente(new AvoirVente());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
            }




        return item;
        }
    }

    @Override
    public AvoirVenteItemDto toDto(AvoirVenteItem item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteItemDto dto = new AvoirVenteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontantAvoir()))
                dto.setMontantAvoir(item.getMontantAvoir());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.avoirVente && item.getAvoirVente()!=null) {
            dto.setAvoirVente(avoirVenteConverter.toDto(item.getAvoirVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.depot = value;
        this.avoirVente = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
