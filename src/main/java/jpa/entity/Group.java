package jpa.entity;

import jakarta.persistence.*;
import lombok.NonNull;
import lombok.ToString;

@NonNull
@ToString(callSuper = true)
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int x;
    private int count=3;


    @OneToMany(mappedBy = "id")
    private Mountain mountain;
    @ManyToMany
    private Climber[] climbers = new Climber[count];
    private boolean isOpen = true;

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }


    public Climber[] getClimbers() {
        return climbers;
    }


    public void getStatus() {
        if (x == climbers.length) {
            System.out.println("Группа закрыта");
        } else {
            System.out.println("Группа открыта для записи");
        }
    }

    public void addClimber(Climber climber) {
        if (isOpen == true) {
            for (int i = 0; i < climbers.length; i += 1) {
                if (climbers[i] == null) {
                    climbers[i] = climber;
                    x += 1;
                    System.out.println(x);
                    return;
                }
            }
            isOpen = false;
        }
        System.out.println("Группа закрыта альпинист " + climber.getName() + " не попадает в эту группу");

    }
}
