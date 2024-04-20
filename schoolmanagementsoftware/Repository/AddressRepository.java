package com.example.schoolmanagementsoftware.Repository;

import com.example.schoolmanagementsoftware.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
