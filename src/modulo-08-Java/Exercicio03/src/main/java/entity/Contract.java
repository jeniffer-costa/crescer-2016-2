package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jeniffer.costa
 */
@Entity
@Table (name = "CONTRACT")
public class Contract implements Serializable {
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT")
    private Long idContract;
    
    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescription;
    
    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;
    
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebSite;
    
    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;
    
    @Basic(optional = false)
    @Column(name = "CLIENT_ID_CLIENT")
    private Long clientIdClient;

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsWebSite() {
        return dsWebSite;
    }

    public void setDsWebSite(String dsWebSite) {
        this.dsWebSite = dsWebSite;
    }

    public String getNmContract() {
        return nmContract;
    }

    public void setNmContract(String nmContract) {
        this.nmContract = nmContract;
    }

    public Long getClientIdClient() {
        return clientIdClient;
    }

    public void setClientIdClient(Long clientIdClient) {
        this.clientIdClient = clientIdClient;
    }

}
