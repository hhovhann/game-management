package com.hhovhann.gamemanagement.entity.data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Geography {
    @NotBlank
    String country;
    @NotBlank
    String city;
}
