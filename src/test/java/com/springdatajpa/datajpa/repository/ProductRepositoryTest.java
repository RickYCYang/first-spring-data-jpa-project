package com.springdatajpa.datajpa.repository;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springdatajpa.datajpa.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 desc");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product.jpg");

        // save product
        Product savedObject = productRepository.save(product);

        // display product info
        System.out.println("id: " + savedObject.getId());
        System.out.println("product: " + product.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 6L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 6L;
        Product product = productRepository.findById(id).get();
        System.out.println("product: " + product);
    }

    @Test
    void saveAllMethod() {
        // create multiple products
        // create product 2
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 desc");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.jpg");

        // create product 3
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 desc");
        product3.setSku("100ABCDEF");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.jpg");

        // save products
        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println("product: " + product);
        }
    }

    @Test
    void deleteByIdMethod() {
        Long id = 6L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        Long id = 7L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        // delete all without arg
        // productRepository.deleteAll();

        // delete specific instances
        Product product1 = productRepository.findById(11L).get();
        Product product2 = productRepository.findById(12L).get();
        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsMethod() {
        boolean product1Exists = productRepository.existsById(12L);
        boolean product2Exists = productRepository.existsById(14L);
        System.out.println("1" + product1Exists);
        System.out.println("2" + product2Exists);

    }

}
