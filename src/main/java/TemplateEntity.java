import javax.persistence.*;

@Entity
@Table(name="templateentity")
@SequenceGenerator(
        name="SEQ_STORE",
        sequenceName="template_entity_sequence"
)
public class TemplateEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
    @Column(name="templateentity_id")
    private Long id;
    @Column
    private String test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TemplateEntity{" +
                "id=" + id +
                ", test='" + test + '\'' +
                '}';
    }
}
