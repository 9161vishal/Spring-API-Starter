package com.spring.spring_api_starter.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
    
    public Category(String name) {
        this.name = name;
    }

    public Category(byte id) {
        this.id = id;
    }

}
