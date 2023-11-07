package  ma.zsmart.stocky.ws.converter.chequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.stocky.ws.converter.gestionchequeffet.TypeInstrumentConverter;
import ma.zsmart.stocky.ws.converter.gestionchequeffet.ChequeEffetConverter;



import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.chequeffet.Instrument;
import ma.zsmart.stocky.ws.dto.chequeffet.InstrumentDto;

@Component
public class InstrumentConverter extends AbstractConverter<Instrument, InstrumentDto> {

    @Autowired
    private TypeInstrumentConverter typeInstrumentConverter ;
    @Autowired
    private ChequeEffetConverter chequeEffetConverter ;
    private boolean typeInstrument;
    private boolean chequeEffet;

    public  InstrumentConverter(){
        super(Instrument.class, InstrumentDto.class);
    }

    @Override
    public Instrument toItem(InstrumentDto dto) {
        if (dto == null) {
            return null;
        } else {
        Instrument item = new Instrument();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(this.typeInstrument && dto.getTypeInstrument()!=null &&  dto.getTypeInstrument().getId() != null)
                item.setTypeInstrument(typeInstrumentConverter.toItem(dto.getTypeInstrument())) ;

            if(this.chequeEffet && dto.getChequeEffet()!=null &&  dto.getChequeEffet().getId() != null)
                item.setChequeEffet(chequeEffetConverter.toItem(dto.getChequeEffet())) ;




        return item;
        }
    }

    @Override
    public InstrumentDto toDto(Instrument item) {
        if (item == null) {
            return null;
        } else {
            InstrumentDto dto = new InstrumentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.typeInstrument && item.getTypeInstrument()!=null) {
            dto.setTypeInstrument(typeInstrumentConverter.toDto(item.getTypeInstrument())) ;
        }
        if(this.chequeEffet && item.getChequeEffet()!=null) {
            dto.setChequeEffet(chequeEffetConverter.toDto(item.getChequeEffet())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.typeInstrument = value;
        this.chequeEffet = value;
    }


    public TypeInstrumentConverter getTypeInstrumentConverter(){
        return this.typeInstrumentConverter;
    }
    public void setTypeInstrumentConverter(TypeInstrumentConverter typeInstrumentConverter ){
        this.typeInstrumentConverter = typeInstrumentConverter;
    }
    public ChequeEffetConverter getChequeEffetConverter(){
        return this.chequeEffetConverter;
    }
    public void setChequeEffetConverter(ChequeEffetConverter chequeEffetConverter ){
        this.chequeEffetConverter = chequeEffetConverter;
    }
    public boolean  isTypeInstrument(){
        return this.typeInstrument;
    }
    public void  setTypeInstrument(boolean typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public boolean  isChequeEffet(){
        return this.chequeEffet;
    }
    public void  setChequeEffet(boolean chequeEffet){
        this.chequeEffet = chequeEffet;
    }
}
