package com.michelneeser.tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    public String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    public List<String> ingredients;

}