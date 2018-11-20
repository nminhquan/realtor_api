package com.squirrel.realtor.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
//@Entity
public class User {
    String id;
    String name;
    int age;
}
