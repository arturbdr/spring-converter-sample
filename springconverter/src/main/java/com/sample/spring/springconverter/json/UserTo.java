package com.sample.spring.springconverter.json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTo {
    private String nome;
    private int idade;
}
