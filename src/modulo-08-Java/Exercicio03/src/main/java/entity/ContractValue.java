package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jeniffer.costa
 */
@Entity
@Table (name = "CONTRACT_VALUE")
public class ContractValue implements Serializable {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private Long idContractValue;
    
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    
    @Column(name = "DS_PERIODICITY")
    @Basic(optional = false)
    private String dsPeriodicity;

    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    @Basic(optional = false)
    private Long vlAmountContractValue;

    @Column(name = "VL_MONTHLY_USD")
    @Basic(optional = false)
    private Long vlMonthlyUsd;
    
    @OneToOne
    private Contract contract;

    public Long getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(Long idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public Long getVlAmountContractValue() {
        return vlAmountContractValue;
    }

    public void setVlAmountContractValue(Long vlAmountContractValue) {
        this.vlAmountContractValue = vlAmountContractValue;
    }

    public Long getVlMonthlyUsd() {
        return vlMonthlyUsd;
    }

    public void setVlMonthlyUsd(Long vlMonthlyUsd) {
        this.vlMonthlyUsd = vlMonthlyUsd;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
    
    
}
