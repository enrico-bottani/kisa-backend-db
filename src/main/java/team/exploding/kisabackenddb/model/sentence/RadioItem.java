package team.exploding.kisabackenddb.model.sentence;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "radio_item")
public class RadioItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="RADIO_GROUP_ID", nullable=false)
    RadioGroup radios;

    boolean correct = false;
    private String value;
}
