package  ma.zsmart.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeTransaction;
import ma.zsmart.stocky.ws.dto.gestionchequeffet.TypeTransactionDto;

@Component
public class TypeTransactionConverter extends AbstractConverter<TypeTransaction, TypeTransactionDto> {


    public  TypeTransactionConverter(){
        super(TypeTransaction.class, TypeTransactionDto.class);
    }

    @Override
    public TypeTransaction toItem(TypeTransactionDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeTransaction item = new TypeTransaction();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public TypeTransactionDto toDto(TypeTransaction item) {
        if (item == null) {
            return null;
        } else {
            TypeTransactionDto dto = new TypeTransactionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
