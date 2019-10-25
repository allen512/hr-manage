package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Department {

    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
    private Long parentId;
    @JsonIgnore
    private String depPath;
    private boolean enabled;
    private boolean isParent;
    @JsonIgnore
    private Integer result;
    private List<Department> children = new ArrayList<>();


}
