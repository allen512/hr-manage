package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Menu implements Serializable {
    private Long id;
    @JsonIgnore
    private String url;
    private String path;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Object component;
    private String name;
    private String iconCls;
    @JsonIgnore
    private Long parentId;
    private boolean enabled;
    @JsonIgnore
    private List<Role> roles;
    private List<Menu> children;
    private MenuMeta meta;
}
