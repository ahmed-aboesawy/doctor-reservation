package com.doctorreservation.demo.adapter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authgroups")
@Getter
@NoArgsConstructor
public class AuthGroup extends BaseEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    @Column(name = "username", nullable = false)
    @Setter
    private String username;

    @Column(name = "authgroup" )
    @Setter
    private String authGroup;

    public AuthGroup(String username, String authGroup) {
        setUsername(username);
        setAuthGroup(authGroup);
    }
}
