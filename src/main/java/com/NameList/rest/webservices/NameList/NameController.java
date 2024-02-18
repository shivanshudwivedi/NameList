package com.NameList.rest.webservices.NameList;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class NameController {

    private NameDaoService service;

    public NameController(NameDaoService service){
        this.service = service;
    }

    @GetMapping("/names")
    public List<Name> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/names/{id}")
    public Name retireveName(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/names")
    public ResponseEntity<Name> createName(@RequestBody Name name){

        Name savedName = service.save(name);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedName.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/names/{id}")
    public void deleteName(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/names/{id}")
    public ResponseEntity<Name> updateName(@PathVariable int id, @RequestBody Name name){
        Name updatedName = service.updateName(id, name);

        if(updatedName == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedName);
    }
}
