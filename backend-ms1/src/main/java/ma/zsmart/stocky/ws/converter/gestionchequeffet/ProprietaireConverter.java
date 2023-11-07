package  ma.zsmart.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Proprietaire;
import ma.zsmart.stocky.ws.dto.gestionchequeffet.ProprietaireDto;

@Component
public class ProprietaireConverter extends AbstractConverter<Proprietaire, ProprietaireDto> {


    public  ProprietaireConverter(){
        super(Proprietaire.class, ProprietaireDto.class);
    }

    @Override
    public Proprietaire toItem(ProprietaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Proprietaire item = new Proprietaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());



        return item;
        }
    }

    @Override
    public ProprietaireDto toDto(Proprietaire item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireDto dto = new ProprietaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
