package com.example.auvik.womensafety;

/**
 * Created by Auvik on 01-Jan-17.
 */

public class Product {

    private String thana;
    private String phoneno;
    private String thanaloc;
    private String thanageo;

    public Product(String thana, String phoneno, String thanaloc, String thanageo) {
        this.thana = thana;
        this.phoneno = phoneno;
        this.thanaloc= thanaloc;
        this.thanageo= thanageo;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getThana() {
        return thana;
    }

    public void setPhoneno(String phoneno) {

        this.phoneno = phoneno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setThanaloc(String thanaloc) {

        this.thanaloc = thanaloc;
    }

    public String getThanaloc() {
        return thanaloc;
    }

    public void setThanageo(String thanageo) {
        this.thanageo = thanageo;
    }

    public String getThanageo() {
        return thanageo;
    }
}
