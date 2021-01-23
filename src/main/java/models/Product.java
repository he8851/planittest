package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("productname")
    private String productname;

    @JsonProperty("productsingleprice")
    private String productsingleprice;

    @JsonProperty("producttotalprice")
    private String producttotalprice;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductsingleprice() {
        return productsingleprice;
    }

    public void setProductsingleprice(String productsingleprice) {
        this.productsingleprice = productsingleprice;
    }

    public String getProducttotalprice() {
        return producttotalprice;
    }

    public void setProducttotalprice(String producttotalprice) {
        this.producttotalprice = producttotalprice;
    }
}
