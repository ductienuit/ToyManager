/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.common.IDTO;
import dto.common.IName;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class Toy implements IDTO, IName {

    private BigInteger id;
    private String name;
    private BigDecimal price;
    private BigInteger categoryID;
    private Boolean gender;
    private String imageURI;
    private String description;
    private Category category;

    public Toy(BigInteger id, String name, BigDecimal price, BigInteger categoryID, Boolean gender, String imageURI, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
        this.gender = gender;
        this.imageURI = imageURI;
        this.description = description;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of imageURI
     *
     * @return the value of imageURI
     */
    public String getImageURI() {
        return imageURI;
    }

    /**
     * Set the value of imageURI
     *
     * @param imageURI new value of imageURI
     */
    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public Boolean isGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * Get the value of categoryID
     *
     * @return the value of categoryID
     */
    public BigInteger getCategoryID() {
        return categoryID;
    }

    /**
     * Set the value of categoryID
     *
     * @param categoryID new value of categoryID
     */
    public void setCategoryID(BigInteger categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    @Override
    public BigInteger getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
