package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jeniffer.costa
 */
@Entity
@Table (name = "SERVICO")
public class Servico implements Serializable{
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;
    
     @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    @Basic(optional = false)
    @Column(name = "DS_PERIDIOCIDADE")
    private String dsPeridiocidade;

    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;

    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebSite;

    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;

    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private String vlsMensalUSD;

    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private String vlTotalServico;

    @ManyToOne
    private Usuario usuario;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeridiocidade() {
        return dsPeridiocidade;
    }

    public void setDsPeridiocidade(String dsPeridiocidade) {
        this.dsPeridiocidade = dsPeridiocidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebSite() {
        return dsWebSite;
    }

    public void setDsWebSite(String dsWebSite) {
        this.dsWebSite = dsWebSite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public String getVlsMensalUSD() {
        return vlsMensalUSD;
    }

    public void setVlsMensalUSD(String vlsMensalUSD) {
        this.vlsMensalUSD = vlsMensalUSD;
    }

    public String getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(String vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
