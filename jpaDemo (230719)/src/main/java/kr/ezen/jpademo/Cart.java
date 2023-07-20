package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Cart {  //cart는 자식
    @Id
    @Column(name = "cart_id")
    private Long id;
    @OneToOne
    //내가 참조할 칼럼명을 넣음
    //cart와 member가 서로 참조하게 됨
    //일반적인 조인은 이너조인 nullable = false //null을 허용하지 않겟다
    //이저조인은 조인의 기준에 따라 달라진다.

    //FK가 만들어짐

    @JoinColumn(name = "member_id",nullable = false)
    private Member member;  //forgine key

//관계향 데이터 베이스 에서는 FK가 하나면 양방향 가능


  @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                /*", member=" + member +*/
                '}';
    }
}

