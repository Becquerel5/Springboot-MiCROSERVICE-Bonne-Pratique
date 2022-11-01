package net.dt.hosting.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private  String id;
    private  String name;
    private  String email;


}
