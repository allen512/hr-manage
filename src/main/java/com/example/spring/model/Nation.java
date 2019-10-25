package com.example.spring.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Nation {
    private Long id;
    @EqualsAndHashCode.Include
    @NonNull
    private String name;
}
