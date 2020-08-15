package com.dongbiao.gilederose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static com.dongbiao.gilederose.ProductType.BACKSTAGEPASS;
import static com.dongbiao.gilederose.ProductType.COMMONPRODUCT;

@SpringBootApplication
public class GilederoseApplication {

    public static void main(String[] args) {
        List<Product> products = buildData();
        for (Product product :
                products) {
            if (ValidValuesValidator.validate(product)) {
                Product updatedProduct = product.getProductType().equals(COMMONPRODUCT) ? CommonProductService.updateProduct(product) : BackstagePassService.updateProduct(product);
                System.out.println("Product id is " + updatedProduct.getId() +
                        ", type is " + updatedProduct.getProductType() +
                        ", sellIn is " + updatedProduct.getSellIn() +
                        ", quality is " + updatedProduct.getQuality());
            } else {
                System.out.println("No need to update. Product id is " + product.getId() +
                        ", type is " + product.getProductType() +
                        ", sellIn is " + product.getSellIn() +
                        ", quality is " + product.getQuality());
            }
        }
        SpringApplication.run(GilederoseApplication.class, args);
    }

    private static List<Product> buildData() {
        List<Product> products = new ArrayList<>();

        products.add(Product.builder().id("1").productType(COMMONPRODUCT).sellIn(50).quality(50).build());
        products.add(Product.builder().id("2").productType(COMMONPRODUCT).sellIn(49).quality(50).build());
        products.add(Product.builder().id("3").productType(COMMONPRODUCT).sellIn(50).quality(49).build());
        products.add(Product.builder().id("4").productType(COMMONPRODUCT).sellIn(1).quality(50).build());
        products.add(Product.builder().id("5").productType(COMMONPRODUCT).sellIn(0).quality(50).build());
        products.add(Product.builder().id("6").productType(COMMONPRODUCT).sellIn(50).quality(0).build());
        products.add(Product.builder().id("7").productType(COMMONPRODUCT).sellIn(1).quality(0).build());
        products.add(Product.builder().id("8").productType(COMMONPRODUCT).sellIn(0).quality(0).build());

        products.add(Product.builder().id("9").productType(BACKSTAGEPASS).sellIn(50).quality(50).build());
        products.add(Product.builder().id("10").productType(BACKSTAGEPASS).sellIn(50).quality(0).build());
        products.add(Product.builder().id("11").productType(BACKSTAGEPASS).sellIn(10).quality(10).build());
        products.add(Product.builder().id("12").productType(BACKSTAGEPASS).sellIn(3).quality(0).build());
        products.add(Product.builder().id("13").productType(BACKSTAGEPASS).sellIn(3).quality(10).build());
        products.add(Product.builder().id("14").productType(BACKSTAGEPASS).sellIn(1).quality(50).build());
        products.add(Product.builder().id("15").productType(BACKSTAGEPASS).sellIn(0).quality(50).build());

        return products;
    }
}
