package com.bogdan.garbagecollector.controller;

import com.bogdan.garbagecollector.dto.GarbageType;
import com.bogdan.garbagecollector.dto.RecyclingCenterDTO;
import com.bogdan.garbagecollector.service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recycling-center")
public class RecyclingCenterController {

    private final RecyclingCenterService recyclingCenterService;

    @Autowired
    public RecyclingCenterController(RecyclingCenterService recyclingCenterService) {
        this.recyclingCenterService = recyclingCenterService;
    }

    @PostMapping
    public String create(@RequestBody RecyclingCenterDTO recyclingCenterDTO) {
        return recyclingCenterService.create(recyclingCenterDTO);
    }

    @PostMapping(path = "/{id}/{garbageType}")
    public String addGarbageTypes(@PathVariable int id,
                                  @PathVariable(name = "garbageType") GarbageType garbageType) {
        return recyclingCenterService.addGarbageTypes(id,garbageType);
    }

    @GetMapping
    public List<RecyclingCenterDTO> readAll() {
        return recyclingCenterService.readAll();
    }

    @GetMapping(path = "/{id}")
    public RecyclingCenterDTO read(@PathVariable int id) {
        return recyclingCenterService.read(id);
    }

    @PutMapping(path = "/{id}")
    public String updateName (@PathVariable int id, @RequestParam(name = "name") String name) {
        return recyclingCenterService.updateName(id,name);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        return recyclingCenterService.delete(id);
    }

    @DeleteMapping(path = "/{id}/{garbage-type}")
    public String removeGarbageTypes (@PathVariable int id, @PathVariable GarbageType garbageType) {
        return recyclingCenterService.removeGarbageTypes(id, garbageType);
    }
}
