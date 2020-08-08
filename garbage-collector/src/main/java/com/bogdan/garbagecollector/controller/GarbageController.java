package com.bogdan.garbagecollector.controller;

import com.bogdan.garbagecollector.dto.ClientDTO;
import com.bogdan.garbagecollector.dto.GarbageDTO;
import com.bogdan.garbagecollector.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/garbage")
public class GarbageController{
    private final GarbageService garbageService;

    @Autowired
    public GarbageController(GarbageService garbageService) {
        this.garbageService = garbageService;
    }

    @PostMapping
    public String create(@RequestBody GarbageDTO garbageDTO){
        return garbageService.create(garbageDTO);
    }

    @GetMapping
    public List<GarbageDTO> read(){
        return garbageService.readAll();
    }

    @GetMapping(path = "/{id}")
    public GarbageDTO readByID(@PathVariable int id){
        return garbageService.readByID(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@PathVariable int id, @RequestBody GarbageDTO newGarbage){
        return garbageService.update(id,newGarbage);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id){
        return garbageService.delete(id);
    }
}
