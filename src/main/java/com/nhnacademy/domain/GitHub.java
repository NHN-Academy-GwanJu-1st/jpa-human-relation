package com.nhnacademy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class GitHub {
    private String access_token;
    private String scope;
    private String token_type;
}
