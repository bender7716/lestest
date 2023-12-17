package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.technologicalprocess.TechnologicalProcessDto;
import org.example.service.rest.impl.TechnologicalProcessRestServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/technological-process")
public class TechnologicalProcessRestController {
    private final TechnologicalProcessRestServiceImpl technologicalProcessService;

    @GetMapping()
    public ResponseEntity<List<TechnologicalProcessDto>> getAll() {
        List<TechnologicalProcessDto> allTechnologicalProcess = technologicalProcessService.getAll();
        return ResponseEntity.ok(allTechnologicalProcess);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologicalProcessDto> getById(@PathVariable Long id){
        TechnologicalProcessDto technologicalProcessDto = technologicalProcessService.getById(id);
        return ResponseEntity.ok(technologicalProcessDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TechnologicalProcessDto> delete(@PathVariable Long id){
        technologicalProcessService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<TechnologicalProcessDto> create(@RequestBody TechnologicalProcessDto dto){
        TechnologicalProcessDto technologicalProcessDto = technologicalProcessService.create(dto);
        return ResponseEntity.ok(technologicalProcessDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologicalProcessDto> update(@PathVariable Long id, @RequestBody TechnologicalProcessDto dto){
        TechnologicalProcessDto technologicalProcessDto = technologicalProcessService.update(dto, id);
        return ResponseEntity.ok(technologicalProcessDto);
    }

    @GetMapping("/{id}/start-job")
    public ResponseEntity<TechnologicalProcessDto> startJob(@PathVariable Long id){
        technologicalProcessService.startJob(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}/end-job")
    public ResponseEntity<TechnologicalProcessDto> endJob(@PathVariable Long id){
        technologicalProcessService.endJob(id);
        return ResponseEntity.ok(null);
    }

}
