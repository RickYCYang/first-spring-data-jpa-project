package com.springdatajpa.datajpa.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springdatajpa.datajpa.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Return the found product entity by using its name as search criteria. If no product entity is
     * found, this method returns null
     * 
     * @param name
     * @return
     */
    public Product findByName(String name);

    /**
     * Return an Optional which contains the found product entity by using its id as search
     * criteria. If no product entity is found, this method returns an empty Optional
     * 
     * @param id
     * @return
     */
    public Optional<Product> findById(long id);

    /**
     * Return the found list of product entities whose title or description is given as the search
     * criteria. If no product entity is found, this method return an empty list.
     * 
     * @param name
     * @param description
     * @return
     */
    public List<Product> findByNameOrDescription(String name, String description);

    /**
     * Return the found list of product entities whose title and description is given as the search
     * criteria. If no product entity is found, this method returns an empty list.
     * 
     * @param name
     * @param description
     * @return
     */
    public List<Product> findByNameAndDescription(String name, String description);

    /**
     * Return the distinct product entity whose title is given as the search criteria. If no product
     * entity is found, this method returns null
     */
    public Product findDistinctByName(String name);

    /**
     * Return the found list of product entities whose price is greater than given price
     * 
     * @param price
     * @return
     */
    public List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Return the found list of product entities whose price is less than given price
     * 
     * @param price
     * @return
     */
    public List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Return the found list of product entities whose name match the given text
     * 
     * @param name
     * @return
     */
    public List<Product> findByNameContaining(String name);

    /**
     * Return the found list of product entities whose name match the given text
     * 
     * @param name
     * @return
     */
    public List<Product> findByNameLike(String name);

    /**
     * Return the found list of product entities whose price is between startPrice and endPrice
     * 
     * @param name
     * @return
     */
    public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Return the found list of product entities whose price is between startPrice and endPrice
     * 
     * @param name
     * @return
     */
    public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Return the found list of product entities whose name is in parameter names
     * 
     * @param names
     * @return
     */
    public List<Product> findByNameIn(List<String> names);

    /**
     * Return the first 2 product entities sorting by name with asc order
     * 
     * @param
     * @return
     */
    public List<Product> findFirst2ByOrderByNameAsc();

    /**
     * Return the top 2 product entities sorting by price with desc order
     * 
     * @param
     * @return
     */
    public List<Product> findTop2ByOrderByPriceDesc();
}
