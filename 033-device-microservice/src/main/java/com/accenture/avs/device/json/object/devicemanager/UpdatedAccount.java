
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "AccountNumber",
    "LastModified"
})
public class UpdatedAccount implements Serializable
{

    /**
     * Account Number of the subscriber whose STB was updated within the given time frame
     * (Required)
     * 
     */
    @JsonProperty("AccountNumber")
    @JsonPropertyDescription("")
    private String accountNumber;
    /**
     * The last modification date when the subscriber's STB was updated.
     * (Required)
     * 
     */
    @JsonProperty("LastModified")
    @JsonPropertyDescription("")
    private String lastModified;

    /**
     * Account Number of the subscriber whose STB was updated within the given time frame
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
     * Account Number of the subscriber whose STB was updated within the given time frame
     * (Required)
     * 
     * @param accountNumber
     *     The AccountNumber
     */
    @JsonProperty("AccountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UpdatedAccount withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * The last modification date when the subscriber's STB was updated.
     * (Required)
     * 
     * @return
     *     The lastModified
     */
    @JsonProperty("LastModified")
    public String getLastModified() {
        return lastModified;
    }

    /**
     * The last modification date when the subscriber's STB was updated.
     * (Required)
     * 
     * @param lastModified
     *     The LastModified
     */
    @JsonProperty("LastModified")
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public UpdatedAccount withLastModified(String lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountNumber).append(lastModified).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdatedAccount) == false) {
            return false;
        }
        UpdatedAccount rhs = ((UpdatedAccount) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(lastModified, rhs.lastModified).isEquals();
    }

}
