package com.Attornatusmateustest.controller;

import com.Attornatusmateustest.model.Address;
import com.Attornatusmateustest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/person/{personId}/address/")
    public ResponseEntity register(@RequestBody Address addressRegister,
                                   @PathVariable(value = "personId")Long personId){
        Address address = addressService.create(addressRegister, personId);
        if(address == null){
            return ResponseEntity.badRequest().body("");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/address")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id){
        Optional<Address> optionalAddress = addressService.findById(id);
        if(optionalAddress.isEmpty()) {
            return ResponseEntity.badRequest().body("Address Not Found!");
        }
        return ResponseEntity.ok(optionalAddress.get());
    }

    @PutMapping("/address/{id}")
    public ResponseEntity updateRegister(@PathVariable(value = "id") Long id, @RequestBody Address addressRegister) {
        Address address = addressService.update(id, addressRegister);
        if (address == null){
            return ResponseEntity.badRequest().body("Address Not Found!");
        }
        return ResponseEntity.ok(address);
    }
    @DeleteMapping("/address/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}
