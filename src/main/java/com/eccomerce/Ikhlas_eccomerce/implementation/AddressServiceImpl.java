package com.eccomerce.Ikhlas_eccomerce.implementation;

import com.eccomerce.Ikhlas_eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.Ikhlas_eccomerce.model.Address;
import com.eccomerce.Ikhlas_eccomerce.model.User;
import com.eccomerce.Ikhlas_eccomerce.payload.AddressDTO;
import com.eccomerce.Ikhlas_eccomerce.repository.AddressRepository;
import com.eccomerce.Ikhlas_eccomerce.repository.UserRepository;
import com.eccomerce.Ikhlas_eccomerce.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);
        List<Address> addressList = user.getAddresses();
        addressList.add(address);
        user.setAddresses(addressList);

        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map((address) -> modelMapper.map(address, AddressDTO.class))
                .toList();
    }

    @Override
    public AddressDTO getAllAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
        return modelMapper.map(address, AddressDTO.class);
    }
}