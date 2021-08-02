package jtech.thirdTask;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte status;

    private String attr1;
    private String attr2;
    private String attr3;

    @ManyToOne()
    private Master master;

    public Detail(byte status, String attr1, String attr2, String attr3, Master master) {
        this.status = status;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
        this.master = master;
    }
}
