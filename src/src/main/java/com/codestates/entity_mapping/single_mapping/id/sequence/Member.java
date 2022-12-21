package com.codestates.entity_mapping.single_mapping.id.sequence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberId;

    public Member(Long memberId) {
        this.memberId = memberId;
    }
}
