import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="professional_details")
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
    @TypeDef(name = "list-array", typeClass = ListArrayType.class)})
@Builder
public class ProfessionDetails implements Serializable {
    private static final long serialVersionUID = -6614132726132052440L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "organization_name")
    private String nameOfTheOrganization;

    @Column(name = "organization_address")
    private String addressOfTheOrganization;

    @Column(name = "organization_state")
    private String stateOfTheOrganization;

    @Column(name = "organization_pin_code")
    private String pinCodeOfTheOrganization;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email_address")
    private String emailAddress;

}
