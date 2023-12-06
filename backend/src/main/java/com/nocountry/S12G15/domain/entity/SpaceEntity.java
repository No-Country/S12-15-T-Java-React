package com.nocountry.S12G15.domain.entity;
import java.util.Date;
import java.util.List;
//import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
import lombok.Data;
//import org.hibernate.annotations.GenericGenerator;
@Entity
@Data
//@NoArgsConstructor
//@Getter
//@Setter
//@Document(collection= "space")
public class SpaceEntity {
    @Id
    private String id;
  //  @Column(name = "Nombre")
    private String name;
  //  @Column(name = "Descripcion")
    private String description;
  //  @Column(name = "imagen")
    private String coverImage;
    //private List<User> users = new ArrayList<>();
    @CreatedDate
    private Date lastModified;
    @CreatedDate
    private Date createdAt;

    @OneToMany
    //(mappedBy = "BoardEntity")
    private List<BoardEntity> boardEntityList;

    @OneToMany
            //(mappedBy = "ChannelEntity")
    private List<ChannelEntity> ChannelEntityList;


}
