package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/Address")
@RequiredArgsConstructor
public class AddressController {

    Logger logger = LoggerFactory.getLogger(AddressController.class);
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress(){
        logger.info("inside the get all Address");
        return ResponseEntity.status(200).body(addressService.getAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside add Address");
     addressService.addAddress(addressDTO);
        return ResponseEntity.ok().body(new ApiResponse("Address added"));

    }

    @PutMapping("/Update")
    public ResponseEntity UpdateAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside Update Address");
        addressService.updateAddress(addressDTO);

        return ResponseEntity.ok().body(new ApiResponse("Address Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        logger.info("inside delete Profile");
        addressService.deleteAddress(id);
        return ResponseEntity.ok().body(new ApiResponse("Profile Deleted"));

    }

    //---------------------------  end CRUD  ---------------------------------

}
