package com.example.ebankingbackend.dtos;
import lombok.Data;


@Data //getters et setters
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;


}
