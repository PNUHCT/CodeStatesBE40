package com.codestates.entity_mapping.single_mapping.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private Long memberId;
}
