package com.company.ioc;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder() {
        // this.iEncoder = new Base64Encoder();
        this.iEncoder = new UrlEncoder();
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }

}
