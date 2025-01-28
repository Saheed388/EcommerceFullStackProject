package com.eccomerce.Ikhlas_eccomerce.Controller;

import com.eccomerce.Ikhlas_eccomerce.model.User;
import com.eccomerce.Ikhlas_eccomerce.payload.AddressDTO;
import com.eccomerce.Ikhlas_eccomerce.security.util.AuthUtil;
import com.eccomerce.Ikhlas_eccomerce.service.AddressService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AuthUtil authUtil;

    @Autowired
    AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }
    @GetMapping("/addresses")
    public  ResponseEntity<List<AddressDTO>> getAddress(){
        List<AddressDTO> addressDTO = addressService.getAllAddress();
        return new ResponseEntity<List<AddressDTO>>(addressDTO, HttpStatus.OK);

    }

    @GetMapping("/addresses/{addressId}")
    public  ResponseEntity<AddressDTO> deleteAddress(@PathVariable Long addressId){
        AddressDTO addressDTO = addressService.getAllAddressById(addressId);
        return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.OK);

    }
}
