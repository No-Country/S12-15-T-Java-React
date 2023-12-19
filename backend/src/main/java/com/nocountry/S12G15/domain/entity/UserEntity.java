package com.nocountry.S12G15.domain.entity;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.nocountry.S12G15.enums.RolUser;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private boolean disabled=false;

    @Column(name = "name", length = 85)
    private String name;

    @Column(name = "last_name", length = 95)
    private String lastName;

    @Column(name = "email", unique = true, length = 110) //nullabe
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "realUserName", nullable = false)
    private String realUserName;

    @Column(name="rol")
    @Enumerated(EnumType.STRING)
    private RolUser rolUser;

    @Column(name="password", nullable = false)
    private String password;

    @OneToOne
    protected ImageEntity imageEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SpaceEntity> spaceEntityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rolUser.name()));
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
