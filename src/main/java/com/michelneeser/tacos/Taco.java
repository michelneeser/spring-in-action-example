package com.michelneeser.tacos;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    public String name;
    public List<String> ingredients;

}