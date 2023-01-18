package com.Attornatusmateustest.controller;

import com.Attornatusmateustest.model.Address;
import com.Attornatusmateustest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody Address addressRegister) {
        Address address = addressService.create(addressRegister);
        if (address == null) {
            return ResponseEntity.badRequest().body("");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity listAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {
        Optional<Address> optionalAddress = addressService.findById(id);
        if (optionalAddress.isEmpty()) {
            return ResponseEntity.badRequest().body("Address Not Found!");
        }
        return ResponseEntity.ok(optionalAddress.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRegister(@PathVariable(value = "id") Long id, @RequestBody Address addressRegister) {
        Address address = addressService.update(id, addressRegister);
        if (address == null){
            return ResponseEntity.badRequest().body("Address Not Found!");
        }
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}