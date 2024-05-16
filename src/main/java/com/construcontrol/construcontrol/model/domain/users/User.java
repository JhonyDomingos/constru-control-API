package com.construcontrol.construcontrol.model.domain.users;

import com.construcontrol.construcontrol.model.domain.users.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    protected String name;
    @Column(name = "phone")
    protected String phone;
    @Column(unique = true, name = "email")
    protected String email;
    @Enumerated(EnumType.STRING)//
    private UserType userType;
}