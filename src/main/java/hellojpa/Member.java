package hellojpa;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    // 연관관계 편의 메서드
    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
