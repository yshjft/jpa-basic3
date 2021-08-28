package hellojpa.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // DTYPE에 들어가는 값 설정(기본은 entity명)
public class Book extends Item{
    private String author;
    private String isbn;
}
