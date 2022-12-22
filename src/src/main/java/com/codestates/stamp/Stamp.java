package com.codestates.stamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Table
public class Stamp {
    @Id
    private long stampId;
    private int stampCount;
    private long memberId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("last_modified_at")
    private LocalDateTime modifiedAt;

    public Stamp(long memberId) {
        this.memberId = memberId;
    }
}
