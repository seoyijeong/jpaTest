package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
//    @GeneratedValue
    @Column(name = "customer_id")
    private String id;
    private String password;
    private String name;
    private String email;
    private Date inDate;
    private Date upDate;

    //Customer 하나에 여러게시글
    //fetch= FetchType.EAGER : 두 엔티티의 정보를 한번에 가져오기(join)
    //fetch= FetchType.LAZY : 필요시에 따로 가져올때 설정,

    //여러개의 게시글을 가질수 잇음
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY) //1:n  //customer하나에 여러게시글
            //customer = Customer{id='tttt', password='1212', name='seo', email='seo@gmail.com',
            // inDate=Wed Jul 19 14:52:47 KST 2023, upDate=Wed Jul 19 14:52:47 KST 2023, list=[]}
            //lazy 는 list가 비어잇음 (필요에 따라서 호출)
    List<Bbs> list = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                ", list=" + list +
                '}';
    }
}
