package com.example.mongo_project.controllers;

import com.example.mongo_project.dtos.StationDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mongo_project.services.StationService;

@RestController
@RequestMapping("/station")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/add")
    public void addStation(StationDTO stationDTO) {
        stationService.addStation(stationDTO);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<StationDTO>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        return stationService.getPage(page, size);
    }

    @GetMapping("/get")
    public ResponseEntity<StationDTO> get(@RequestParam("id") String id) {
        return stationService.get(id);
    }

    @PatchMapping("/update")
    public void update(@RequestBody StationDTO stationDTO) {
        stationService.update(stationDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") String id) {
        stationService.delete(id);
    }

}
