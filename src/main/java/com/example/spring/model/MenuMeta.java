package com.example.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class MenuMeta implements Serializable {

    private boolean keepAlive;
    private boolean requireAuth;

}
