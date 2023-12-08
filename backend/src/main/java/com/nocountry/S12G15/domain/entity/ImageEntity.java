package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class ImageEntity {

    @Id
    @UuidGenerator
    private String idImage;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageContent;

}
