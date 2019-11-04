package com.michelneeser.tacos.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix="taco.orders")
@Data
@Validated
public class OrderProps {

    /**
     * The page size for all lists of this app.
     */
    @Min(value=5, message="must be equal or greater than 5")
    @Max(value=25, message="must be equal or lesser than 25")
    private int pageSize = 20;

}