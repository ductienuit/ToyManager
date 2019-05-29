package dto;
// Generated May 22, 2019 4:10:30 PM by Hibernate Tools 4.3.1

import dto.common.IDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Parameter generated by hbm2java
 */
@Entity
@Table(name = "parameter",
       catalog = "toymanager"
)
public class Parameter implements Serializable, IDTO {
    private long id;
    private String shopName;
    private String shopAddress;
    private String shopPhoneNumber;
    private String shopEmail;

    public Parameter() {
    }

    public Parameter(long id,
                     String shopName,
                     String shopAddress,
                     String shopPhoneNumber,
                     String shopEmail) {
        this.id = id;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopPhoneNumber = shopPhoneNumber;
        this.shopEmail = shopEmail;
    }

    @Id
    @Column(name = "Id",
            unique = true,
            nullable = false)
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ShopName",
            nullable = false)
    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column(name = "ShopAddress",
            nullable = false)
    public String getShopAddress() {
        return this.shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Column(name = "ShopPhoneNumber",
            nullable = false,
            length = 10)
    public String getShopPhoneNumber() {
        return this.shopPhoneNumber;
    }

    public void setShopPhoneNumber(String shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
    }

    @Column(name = "ShopEmail",
            nullable = false)
    public String getShopEmail() {
        return this.shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }
}
