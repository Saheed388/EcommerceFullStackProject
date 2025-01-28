package com.eccomerce.Ikhlas_eccomerce.service;

import com.eccomerce.Ikhlas_eccomerce.model.User;
import com.eccomerce.Ikhlas_eccomerce.payload.AddressDTO;

import java.util.List;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAllAddress();

    AddressDTO getAllAddressById(Long addressId);
}
