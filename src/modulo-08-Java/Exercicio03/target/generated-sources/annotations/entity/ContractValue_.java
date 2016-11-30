package entity;

import entity.Contract;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T22:44:56")
@StaticMetamodel(ContractValue.class)
public class ContractValue_ { 

    public static volatile SingularAttribute<ContractValue, Long> vlAmountContractValue;
    public static volatile SingularAttribute<ContractValue, Long> vlMonthlyUsd;
    public static volatile SingularAttribute<ContractValue, Contract> contract;
    public static volatile SingularAttribute<ContractValue, Long> idContractValue;
    public static volatile SingularAttribute<ContractValue, String> dsCoin;
    public static volatile SingularAttribute<ContractValue, String> dsPeriodicity;

}