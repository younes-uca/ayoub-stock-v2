package  ma.zsmart.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zsmart.stocky.bean.core.gestionchequeffet.ChequeEffet;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.ChequeEffetAdminService;
import ma.zsmart.stocky.ws.converter.gestionchequeffet.ChequeEffetConverter;
import ma.zsmart.stocky.ws.dto.gestionchequeffet.ChequeEffetDto;
import ma.zsmart.stocky.zynerator.controller.AbstractController;
import ma.zsmart.stocky.zynerator.dto.AuditEntityDto;
import ma.zsmart.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zsmart.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zsmart.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/chequeEffet/")
public class ChequeEffetRestAdmin  extends AbstractController<ChequeEffet, ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService, ChequeEffetConverter> {



    @Operation(summary = "upload one chequeEffet")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple chequeEffets")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all chequeEffets")
    @GetMapping("")
    public ResponseEntity<List<ChequeEffetDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a chequeEffet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ChequeEffetDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  chequeEffet")
    @PostMapping("")
    public ResponseEntity<ChequeEffetDto> save(@RequestBody ChequeEffetDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  chequeEffet")
    @PutMapping("")
    public ResponseEntity<ChequeEffetDto> update(@RequestBody ChequeEffetDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of chequeEffet")
    @PostMapping("multiple")
    public ResponseEntity<List<ChequeEffetDto>> delete(@RequestBody List<ChequeEffetDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified chequeEffet")
    @DeleteMapping("")
    public ResponseEntity<ChequeEffetDto> delete(@RequestBody ChequeEffetDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified chequeEffet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple chequeEffets by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by beneficiaire id")
    @GetMapping("beneficiaire/id/{id}")
    public List<ChequeEffetDto> findByBeneficiaireId(@PathVariable Long id){
        return findDtos(service.findByBeneficiaireId(id));
    }
    @Operation(summary = "delete by beneficiaire id")
    @DeleteMapping("beneficiaire/id/{id}")
    public int deleteByBeneficiaireId(@PathVariable Long id){
        return service.deleteByBeneficiaireId(id);
    }
    @Operation(summary = "Finds chequeEffets by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ChequeEffetDto>> findByCriteria(@RequestBody ChequeEffetCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated chequeEffets by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ChequeEffetCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports chequeEffets by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ChequeEffetCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets chequeEffet data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ChequeEffetCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ChequeEffetRestAdmin (ChequeEffetAdminService service, ChequeEffetConverter converter) {
        super(service, converter);
    }




}
