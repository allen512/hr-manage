package com.example.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;

}
