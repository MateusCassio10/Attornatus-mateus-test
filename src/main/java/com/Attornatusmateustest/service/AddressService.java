package com.Attornatusmateustest.service;

import com.Attornatusmateustest.model.Address;
import com.Attornatusmateustest.model.Person;
import com.Attornatusmateustest.repository.AddressRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address create(Address addressRegister) {
        try {
            return addressRepository.save(addressRegister);
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    public List findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public Address update(Long id, Address addressRegister) {
        Optional<Address> optionalAddress = findById(id);
        if (optionalAddress.isEmpty()) {
            return null;
        }
        Address address = optionalAddress.get();
        address.setStreetAddress(addressRegister.getStreetAddress());
        return addressRepository.save(address);
    }
}
