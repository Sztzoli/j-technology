package jtech.thirdTask;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate created;

    private String attr1;

    private String attr2;

    private String attr3;

    @OneToMany(mappedBy = "master", orphanRemoval = true)
    private List<Detail> details;

    public Master(LocalDate created, String attr1, String attr2, String attr3) {
        this.created = created;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
    }
}
