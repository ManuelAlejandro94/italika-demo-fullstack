package com.manuelalvarez.italika.Model.RequestToken;

import lombok.Getter;

@Getter
public class AuthenticationsResponse {
    private final String jwt;

    public AuthenticationsResponse(String jwt) {
        this.jwt = jwt;
    }
}
