package com.NameList.rest.webservices.NameList;

import java.net.URI;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import nonapi.io.github.classgraph.json.JSONUtils;
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

    //Creating a new config route that returns environment variables
    @GetMapping("/config")
    public Map<String, String> getConfig(){
        Map<String, String> env = System.getenv();
        System.out.println(env);
        return env;
    }

    //Creating a new fibonacci route
    @GetMapping("/fib")
    public List<Integer> fibonacci(@RequestParam("length") int length){
        List<Integer> fibonacciSequence = new ArrayList<>();
        for(int i = 0; i < length; i++){
            if(i == 0 || i == 1){
                fibonacciSequence.add(1);
            }
            else{
                fibonacciSequence.add(fibonacciSequence.get(i-1) + fibonacciSequence.get(i-2));
            }
        }
        System.out.println(fibonacciSequence);
        return fibonacciSequence;
    }
}
