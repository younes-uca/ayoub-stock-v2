package  ma.zsmart.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.stocky.ws.converter.stock.VenteConverter;
import ma.zsmart.stocky.ws.converter.commun.DepotConverter;
import ma.zsmart.stocky.ws.converter.stock.ProduitConverter;

import ma.zsmart.stocky.bean.core.stock.Produit;
import ma.zsmart.stocky.bean.core.stock.Vente;


import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.stock.VenteItem;
import ma.zsmart.stocky.ws.dto.stock.VenteItemDto;

@Component
public class VenteItemConverter extends AbstractConverter<VenteItem, VenteItemDto> {

    @Autowired
    private VenteConverter venteConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean vente;
    private boolean depot;

    public  VenteItemConverter(){
        super(VenteItem.class, VenteItemDto.class);
    }

    @Override
    public VenteItem toItem(VenteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        VenteItem item = new VenteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteAvoir()))
                item.setQuantiteAvoir(dto.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantiteVendue()))
                item.setQuantiteVendue(dto.getQuantiteVendue());
            if(StringUtil.isNotEmpty(dto.getRemise()))
                item.setRemise(dto.getRemise());
            if(StringUtil.isNotEmpty(dto.getPrixUttc()))
                item.setPrixUttc(dto.getPrixUttc());
            if(StringUtil.isNotEmpty(dto.getPrixUht()))
                item.setPrixUht(dto.getPrixUht());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
                item.getVente().setId(dto.getVente().getId());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;




        return item;
        }
    }

    @Override
    public VenteItemDto toDto(VenteItem item) {
        if (item == null) {
            return null;
        } else {
            VenteItemDto dto = new VenteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteAvoir()))
                dto.setQuantiteAvoir(item.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(item.getQuantiteVendue()))
                dto.setQuantiteVendue(item.getQuantiteVendue());
            if(StringUtil.isNotEmpty(item.getRemise()))
                dto.setRemise(item.getRemise());
            if(StringUtil.isNotEmpty(item.getPrixUttc()))
                dto.setPrixUttc(item.getPrixUttc());
            if(StringUtil.isNotEmpty(item.getPrixUht()))
                dto.setPrixUht(item.getPrixUht());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.vente = value;
        this.depot = value;
    }


    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
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
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
}
