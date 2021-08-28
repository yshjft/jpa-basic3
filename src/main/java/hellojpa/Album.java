package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DTYPE에 들어가는 값 설정(기본은 entity명)
public class Album extends Item{
    private String artist;
}
