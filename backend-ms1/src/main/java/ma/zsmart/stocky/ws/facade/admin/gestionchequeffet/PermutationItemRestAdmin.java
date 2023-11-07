package  ma.zsmart.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.PermutationItemAdminService;
import ma.zsmart.stocky.ws.converter.gestionchequeffet.PermutationItemConverter;
import ma.zsmart.stocky.ws.dto.gestionchequeffet.PermutationItemDto;
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
@RequestMapping("/api/admin/permutationItem/")
public class PermutationItemRestAdmin  extends AbstractController<PermutationItem, PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService, PermutationItemConverter> {



    @Operation(summary = "upload one permutationItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple permutationItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all permutationItems")
    @GetMapping("")
    public ResponseEntity<List<PermutationItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a permutationItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PermutationItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  permutationItem")
    @PostMapping("")
    public ResponseEntity<PermutationItemDto> save(@RequestBody PermutationItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  permutationItem")
    @PutMapping("")
    public ResponseEntity<PermutationItemDto> update(@RequestBody PermutationItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of permutationItem")
    @PostMapping("multiple")
    public ResponseEntity<List<PermutationItemDto>> delete(@RequestBody List<PermutationItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified permutationItem")
    @DeleteMapping("")
    public ResponseEntity<PermutationItemDto> delete(@RequestBody PermutationItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified permutationItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple permutationItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<PermutationItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by depotOrigine id")
    @GetMapping("depotOrigine/id/{id}")
    public List<PermutationItemDto> findByDepotOrigineId(@PathVariable Long id){
        return findDtos(service.findByDepotOrigineId(id));
    }
    @Operation(summary = "delete by depotOrigine id")
    @DeleteMapping("depotOrigine/id/{id}")
    public int deleteByDepotOrigineId(@PathVariable Long id){
        return service.deleteByDepotOrigineId(id);
    }
    @Operation(summary = "find by depotDestination id")
    @GetMapping("depotDestination/id/{id}")
    public List<PermutationItemDto> findByDepotDestinationId(@PathVariable Long id){
        return findDtos(service.findByDepotDestinationId(id));
    }
    @Operation(summary = "delete by depotDestination id")
    @DeleteMapping("depotDestination/id/{id}")
    public int deleteByDepotDestinationId(@PathVariable Long id){
        return service.deleteByDepotDestinationId(id);
    }
    @Operation(summary = "find by permutation id")
    @GetMapping("permutation/id/{id}")
    public List<PermutationItemDto> findByPermutationId(@PathVariable Long id){
        return findDtos(service.findByPermutationId(id));
    }
    @Operation(summary = "delete by permutation id")
    @DeleteMapping("permutation/id/{id}")
    public int deleteByPermutationId(@PathVariable Long id){
        return service.deleteByPermutationId(id);
    }
    @Operation(summary = "Finds permutationItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PermutationItemDto>> findByCriteria(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated permutationItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports permutationItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets permutationItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PermutationItemRestAdmin (PermutationItemAdminService service, PermutationItemConverter converter) {
        super(service, converter);
    }




}
