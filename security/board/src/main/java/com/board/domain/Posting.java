package com.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_posting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posting {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer", nullable = false)
    private User writer;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column
    private long viewCount;

    public void increaseViewCount() {
        this.viewCount += 1;
    }

    @Builder
    public Posting(String title, String content, User writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.viewCount = 0;
    }
}
