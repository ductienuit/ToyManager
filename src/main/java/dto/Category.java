package dto;
// Generated May 22, 2019 4:10:30 PM by Hibernate Tools 4.3.1

import dto.common.IDTO;
import dto.common.IName;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category",
       catalog = "toymanager"
)
public class Category implements Serializable, IDTO, IName {
    private long id;
    private String name;
    private Set<Toy> toys;

    public Category() {
        this.toys = new HashSet<>(0);
    }

    public Category(long id,
                    String name) {
        this.toys = new HashSet<>(0);
        this.id = id;
        this.name = name;
    }

    public Category(long id,
                    String name,
                    Set<Toy> toys) {
        this.toys = new HashSet<>(0);
        this.id = id;
        this.name = name;
        this.toys = toys;
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

    @Column(name = "Name",
            nullable = false)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "category")
    public Set<Toy> getToys() {
        return this.toys;
    }

    public void setToys(Set<Toy> toys) {
        this.toys = toys;
    }
}
