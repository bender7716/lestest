package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.cutter.CutterDto;
import org.example.service.rest.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/cutter")
public class CutterRestController {

    private final CrudService<CutterDto> cutterService;

    @GetMapping()
    public ResponseEntity<List<CutterDto>> getAll() {
        List<CutterDto> allCutters = cutterService.getAll();
        return ResponseEntity.ok(allCutters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CutterDto> getById(@PathVariable Long id){
        CutterDto cutterDto = cutterService.getById(id);
        return ResponseEntity.ok(cutterDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CutterDto> delete(@PathVariable Long id){
        cutterService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<CutterDto> create(@RequestBody CutterDto dto){
        CutterDto cutterDto = cutterService.create(dto);
        return ResponseEntity.ok(cutterDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CutterDto> update(@PathVariable Long id, @RequestBody CutterDto dto){
        CutterDto cutterDto = cutterService.update(dto, id);
        return ResponseEntity.ok(cutterDto);
    }
}
