package com.nocountry.S12G15.domain.entity;

import com.nocountry.S12G15.enums.RolUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name="user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private boolean disabled=true;

    @Column(name = "name", nullable = false, length = 85)
    private String name;

    @Column(name = "last_name", nullable = false, length = 95)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 110) //nullabe
    private String email;

    @Column(name="rol",nullable = false,unique = true)
    private RolUser rolUser;

    @OneToMany
    private List<SpaceEntity> spaceEntityList;

}
