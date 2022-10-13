package com.tutorial.jwtsecurity.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String nickname, String password, Authority authority) {
        this.nickname = nickname;
        this.password = password;
        this.authority = authority;
    }
}
