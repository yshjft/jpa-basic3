package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/*
 @Inheritance
 strategy: InheritanceType.JOINED, InheritanceType.SINGLE_TABLE, InheritanceType.TABLE_PER_CLASS
 기본: SINGLE_TABLE
 InheritanceType.TABLE_PER_CLASS : 부모 클래스 테이블을 만들지 않는다.
*/
@DiscriminatorColumn
/*
 @DiscriminatorColumn
 DTYPE을 추가한다
 조인 전략: 선택(되도록 사용할 것), @DiscriminatorColumn이 있어야 DTYPE 컬럼 생성
 싱글 테이블: 필수!, @DiscriminatorColumn이 없어도 DTYPE 컬럼 자동 생성
 구현 클래스마다 테이블 전략: 어노테이션 있어도  DTYPE 컬럼 생성 안됨
*/
public abstract class Item {
    /*
     부모 클래스(Item)는 abstract 클래스로 만들어야 한다
     abstract 클래스로 만들지 않을 경우 부모 클래스(Item )를 단독을 사용하는 경우가 있다는 갓이다
    */
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
