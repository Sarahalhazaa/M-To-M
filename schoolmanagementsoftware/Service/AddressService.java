package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.AddressRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getId());
        if (teacher == null) {
            throw new ApiException("id not found");

        }
        Address address = new Address(null, addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address1 = addressRepository.findAddressById(addressDTO.getId());
        if (address1 == null) {
            throw new ApiException("id not found");
        }
        address1.setArea(addressDTO.getArea());
        address1.setStreet(addressDTO.getStreet());
        address1.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address1);

    }

    public void deleteAddress(Integer id) {
        Address address1 = addressRepository.findAddressById(id);
        if (address1 == null) {
            throw new ApiException("id not found");
        }
        addressRepository.delete(address1);
    }
}
