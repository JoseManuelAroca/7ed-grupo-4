package com.atm.buenas_practicas_java.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioPswDto {
    private Long id;
    private String old_password;

    private String new_password;

}
