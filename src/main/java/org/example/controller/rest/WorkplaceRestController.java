package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.workplace.WorkplaceDto;
import org.example.service.rest.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/workplace")
public class WorkplaceRestController {

    private final CrudService<WorkplaceDto> workplaceService;

    @GetMapping()
    public ResponseEntity<List<WorkplaceDto>> getAll() {
        List<WorkplaceDto> allWorkplaces = workplaceService.getAll();
        return ResponseEntity.ok(allWorkplaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkplaceDto> getById(@PathVariable Long id){
        WorkplaceDto workplaceDto = workplaceService.getById(id);
        return ResponseEntity.ok(workplaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkplaceDto> delete(@PathVariable Long id){
        workplaceService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<WorkplaceDto> create(@RequestBody WorkplaceDto dto){
        WorkplaceDto workplaceDto = workplaceService.create(dto);
        return ResponseEntity.ok(workplaceDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkplaceDto> update(@PathVariable Long id, @RequestBody WorkplaceDto dto){
        WorkplaceDto workplaceDto = workplaceService.update(dto, id);
        return ResponseEntity.ok(workplaceDto);
    }

}
