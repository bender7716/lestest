package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.baguette.BaguetteDto;
import org.example.service.rest.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/baguette")
public class BaguetteRestController {

    private final CrudService<BaguetteDto> baguetteService;

    @GetMapping()
    public ResponseEntity<List<BaguetteDto>> getAll() {
        List<BaguetteDto> allBaguette = baguetteService.getAll();
        return ResponseEntity.ok(allBaguette);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaguetteDto> getById(@PathVariable Long id){
        BaguetteDto baguetteDto = baguetteService.getById(id);
        return ResponseEntity.ok(baguetteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaguetteDto> delete(@PathVariable Long id){
        baguetteService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<BaguetteDto> create(@RequestBody BaguetteDto dto){
        BaguetteDto baguetteDto = baguetteService.create(dto);
        return ResponseEntity.ok(baguetteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaguetteDto> update(@PathVariable Long id, @RequestBody BaguetteDto dto){
        BaguetteDto baguetteDto = baguetteService.update(dto, id);
        return ResponseEntity.ok(baguetteDto);
    }
}
