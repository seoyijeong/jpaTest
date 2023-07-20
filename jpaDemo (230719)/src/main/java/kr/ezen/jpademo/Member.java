package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity  //entity만듦
@Getter
@Setter
public class Member {
    @Id
    //cart member 에 둘다 id 이니 칼럼 속성을 추가해 준다
    @Column(name="member_id")
    private Long id;
    private String password;
    private String name;
    private String email;
    //FK를 안만든다.
    @OneToOne(mappedBy = "member") //자기자신 cart에 의해서 mapping됨(조인됨)
    //mappedBy 로 맵핍이 되는쪽이 자식
    //cart,memeber  FK가 두개 만들어짐 (양쪽으로 조인칼럼을 사용 시)
    @JoinColumn(name = "cart_id")
    private Cart cart; //서로 양방향 참조

    //member 뒤에 member.toString이 생략되어 있음
    //lombok에서 toString이 이미 자동으로 생성되어 잇음
    //cart와 member가 계속 toString을 생성하고 있음
    //@Data 를 참조하지 않고 getter와 setter만 참조

    //.StackOverflowError
//양쪽으로 toString을 서로 계속 불러오고 있음

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +  //서로를 계속 참조하여 불러옴 //StackOverflowError
                '}';
    }
}
//member


//crud 작업할때 필요한 repository
//MemberReposiroty interface생성

//관계형은 데이터 베이스 양방향 가능
//객체형은 양방향 불가 (단방향 두번 해줘야 양방향이 됨)
