package com.example.schoolmanagementsoftware.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @Id
    private Integer id;

    @NotEmpty(message ="It must not be empty" )
    private String area ;

    @NotEmpty(message ="It must not be empty" )
    private String street;

    @NotNull(message ="It must not be empty" )
    private Integer buildingNumber;
}
