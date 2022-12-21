package com.codestates.entity_mapping.single_mapping.id.direct;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    private Long memberId;

    public Member(Long memberId) {
        this.memberId = memberId;
    }
}
