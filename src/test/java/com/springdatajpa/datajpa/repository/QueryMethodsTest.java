package com.springdatajpa.datajpa.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springdatajpa.datajpa.entity.Product;

@SpringBootTest
class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products =
                productRepository.findByNameOrDescription("product 1", "product 2 desc");
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products =
                productRepository.findByNameAndDescription("product 1", "product 1 desc");
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(250));
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product");
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product 1");
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products =
                productRepository.findByPriceBetween(new BigDecimal(0), new BigDecimal(200));
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        List<Product> products = productRepository.findByDateCreatedBetween(
                LocalDateTime.of(2024, 12, 7, 18, 29), LocalDateTime.of(2024, 12, 7, 18, 30));
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 3", "product 1"));
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    @Test
    void findTop2ByOrderByPriceDescMethod() {
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

}
