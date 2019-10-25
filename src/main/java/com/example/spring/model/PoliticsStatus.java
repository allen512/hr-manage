package com.example.spring.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class PoliticsStatus {
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
}
