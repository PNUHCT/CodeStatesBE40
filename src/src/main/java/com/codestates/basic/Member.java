package com.codestates.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long memberId;

    private String email;

    public Member(String email) {
        this.email = email;
    }

}
