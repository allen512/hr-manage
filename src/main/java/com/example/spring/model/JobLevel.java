package com.example.spring.model;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class JobLevel {
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
    private String titleLevel;
    private Timestamp createDate;

}
