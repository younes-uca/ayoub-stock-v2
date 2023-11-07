package  ma.zsmart.stocky.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.stocky.ws.converter.stock.AchatConverter;
import ma.zsmart.stocky.ws.converter.stock.AvoirAchatConverter;
import ma.zsmart.stocky.ws.converter.commun.ModePaiementConverter;

import ma.zsmart.stocky.bean.core.stock.Achat;
import ma.zsmart.stocky.bean.core.stock.AvoirAchat;


import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.paiement.PaiementAvoirAchat;
import ma.zsmart.stocky.ws.dto.paiement.PaiementAvoirAchatDto;

@Component
public class PaiementAvoirAchatConverter extends AbstractConverter<PaiementAvoirAchat, PaiementAvoirAchatDto> {

    @Autowired
    private AchatConverter achatConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    private boolean achat;
    private boolean modePaiement;
    private boolean avoirAchat;

    public  PaiementAvoirAchatConverter(){
        super(PaiementAvoirAchat.class, PaiementAvoirAchatDto.class);
    }

    @Override
    public PaiementAvoirAchat toItem(PaiementAvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAvoirAchat item = new PaiementAvoirAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null &&  dto.getModePaiement().getId() != null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(dto.getAvoirAchat() != null && dto.getAvoirAchat().getId() != null){
                item.setAvoirAchat(new AvoirAchat());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
            }




        return item;
        }
    }

    @Override
    public PaiementAvoirAchatDto toDto(PaiementAvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            PaiementAvoirAchatDto dto = new PaiementAvoirAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.avoirAchat && item.getAvoirAchat()!=null) {
            dto.setAvoirAchat(avoirAchatConverter.toDto(item.getAvoirAchat())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
        this.modePaiement = value;
        this.avoirAchat = value;
    }


    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
    public boolean  isAvoirAchat(){
        return this.avoirAchat;
    }
    public void  setAvoirAchat(boolean avoirAchat){
        this.avoirAchat = avoirAchat;
    }
}
