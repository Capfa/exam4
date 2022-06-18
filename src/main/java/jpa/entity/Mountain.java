package jpa.entity;

import jakarta.persistence.*;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@NonNull
@ToString(callSuper = true)
@Entity
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @OneToMany(mappedBy = "mountain")
    private List<ClimbGroup> groups;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    private int height;

    public void setName(String nameValue) {
        if (nameValue.length() < 4) {
            throw new IllegalArgumentException("Значение name должно быть не менее 4 символов");
        }
        name = nameValue;
    }


    public void setCountry(String countryValue) {
        if (countryValue.length() < 4) {
            throw new IllegalArgumentException("Значение country должно быть не менее 5 символов");
        }
        country = countryValue;
    }
    public void setHeight(int mountHeight){
        if (mountHeight <=100) {
            throw new IllegalArgumentException("Значение mountHeight должно быть не меньше 100м");
        }

        height = mountHeight;
    }


}

