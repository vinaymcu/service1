
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "AccountNumber",
    "MACAddress",
    "EquipmentId"
})
public class STBAssignmentDetail implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("MACAddress")
    private String mACAddress;
    @JsonProperty("EquipmentId")
    private Integer equipmentId;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The accountNumber
     */
    @JsonProperty("AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param accountNumber
     *     The AccountNumber
     */
    @JsonProperty("AccountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public STBAssignmentDetail withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The mACAddress
     */
    @JsonProperty("MACAddress")
    public String getMACAddress() {
        return mACAddress;
    }

    /**
     * 
     * @param mACAddress
     *     The MACAddress
     */
    @JsonProperty("MACAddress")
    public void setMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
    }

    public STBAssignmentDetail withMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The equipmentId
     */
    @JsonProperty("EquipmentId")
    public Integer getEquipmentId() {
        return equipmentId;
    }

    /**
     * 
     * @param equipmentId
     *     The EquipmentId
     */
    @JsonProperty("EquipmentId")
    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public STBAssignmentDetail withEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountNumber).append(mACAddress).append(equipmentId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBAssignmentDetail) == false) {
            return false;
        }
        STBAssignmentDetail rhs = ((STBAssignmentDetail) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(mACAddress, rhs.mACAddress).append(equipmentId, rhs.equipmentId).isEquals();
    }

}
