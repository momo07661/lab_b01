package com.ffse2401.lab_b01;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonAPI {
    List<PersonData> personDataList = new ArrayList<>();

    @PostMapping("/person/create")
    public PersonData createPerson(@RequestBody PersonData personData){
        personDataList.add(personData);
        return personData;
    }

    @GetMapping("/person/all")
    public List<PersonData> getPersonDataList(){
        return personDataList;
    }

    @PutMapping("/person/update")
    @ResponseStatus(HttpStatus.OK)
    public PersonData putPersonData (@RequestBody PersonData personData){

        for (PersonData p: personDataList){
            if (p.getHkid().equals(personData.getHkid())){
                //p.setFirstName(personData.getFirstName());
                //p.setLastName(personData.getLastName());
                personDataList.set(personDataList.indexOf(p), personData);
                return personData;
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/person/delete")
    @ResponseStatus(HttpStatus.OK)

    public PersonData deletePersonData(@RequestParam(value = "hkID")String hkID){
        for (PersonData p: personDataList){
            if (p.getHkid().equals(hkID)){
                personDataList.remove(p);
                return p;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


}

