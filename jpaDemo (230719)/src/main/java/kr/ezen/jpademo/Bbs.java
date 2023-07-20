package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Bbs {
    //사용자와 게시글 관계 1 :N (하나의 게시글은 한명)
    //한명의 사용자는 여려개의 게시글
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    //private String writer;

    @ManyToOne //다대일 //여러개의 게시글에 하나의customer
    @JoinColumn(name = "customer_id",nullable = false)
    //bbs에 customer_id를 넣음
    private Customer customer;

    private String content;
    private Long viewCnt;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date regDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date upDate;

    @Override
    public String toString() {
        return "Bbs{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", customer=" + customer +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", regDate=" + regDate +
                ", upDate=" + upDate +
                '}';
    }
}
