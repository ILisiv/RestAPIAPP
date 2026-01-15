package com.Volkov.RestAPIAPP.product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProductRequest extends ProductRequest {
    private final Long id;

    @JsonCreator
    public UpdateProductRequest(@JsonProperty("name") String name,
                                @JsonProperty("id") Long id) {
        super(name); // Passes the name to the ProductRequest constructor
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}