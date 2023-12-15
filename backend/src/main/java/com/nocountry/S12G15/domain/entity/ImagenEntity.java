package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagenEntity {
    @Id
    @UuidGenerator
    private Long id;

    private String name;
    private String imagenUrl;
    private String cloudinaryId;

    public void setName(String originalFilename) {
    }

    public void setImagenUrl(String url) {
    }

    public void setCloudinaryId(String publicId) {
    }

    public Object getCloudinaryId() {
        return null;
    }
}

