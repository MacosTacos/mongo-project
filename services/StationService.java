package com.example.mongo_project.services;

import com.example.mongo_project.dtos.StationDTO;
import com.example.mongo_project.model.Station;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.mongo_project.repositories.StationRepository;

import java.util.NoSuchElementException;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final ModelMapper modelMapper;

    public StationService(StationRepository stationRepository, ModelMapper modelMapper) {
        this.stationRepository = stationRepository;
        this.modelMapper = modelMapper;
    }

    public void addStation(StationDTO stationDTO) {
        Station station = modelMapper.map(stationDTO, Station.class);
        stationRepository.save(station);
    }

    public ResponseEntity<Page<StationDTO>> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Station> stationPage = stationRepository.findAll(pageable);
        Page<StationDTO> stationDTOS = stationPage.map(station -> modelMapper.map(station, StationDTO.class));
        return ResponseEntity.ok(stationDTOS);
    }

    public ResponseEntity<StationDTO> get(String id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("station with id " + id + " not found"));
        StationDTO stationDTO = modelMapper.map(station, StationDTO.class);
        return ResponseEntity.ok(stationDTO);
    }

    public void update(StationDTO stationDTO) {
        Station station = stationRepository.findById(stationDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("station with id " + stationDTO.getId() + " not found"));
        if (stationDTO.getName() != null) {
            station.setName(stationDTO.getName());
        }
        if (stationDTO.getCode() != null) {
            station.setCode(stationDTO.getCode());
        }
        if (stationDTO.getLocation() != null) {
            station.setLocation(stationDTO.getLocation());
        }
        if (stationDTO.getOpenedYear() != null) {
            station.setOpenedYear(stationDTO.getOpenedYear());
        }
        if (stationDTO.getPassengersServed() != null) {
            station.setOpenedYear(stationDTO.getPassengersServed());
        }
        if (stationDTO.getPlatforms() != null) {
            station.setPlatforms(stationDTO.getPlatforms());
        }
        if (stationDTO.getServices() != null) {
            station.setServices(stationDTO.getServices());
        }
        stationRepository.save(station);
    }

    public void delete(String id) {
        stationRepository.deleteById(id);
    }
}
