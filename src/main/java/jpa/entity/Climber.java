package jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NonNull
@ToString(callSuper = true)
@Entity
public class Climber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String adress;

    @ManyToMany(mappedBy = "climbers")
    private List<ClimbGroup> groups;

    public String getName(){
        return name;
    }
    public String getAdress(){
        return adress;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Значение name должно быть не менее 3 символов");
        }
        this.name = name;
    }


    public void setAdress(String adress) {
        if (adress.length() < 5) {
            throw new IllegalArgumentException("Значение adress должно быть не менее 5 символов");
        }
        this.adress = adress;
    }


}

