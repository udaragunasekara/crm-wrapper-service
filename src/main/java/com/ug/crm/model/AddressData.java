package com.ug.crm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddressData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-01T10:51:03.866Z[GMT]")
public class AddressData  implements Serializable  {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets addressType
   */
  public enum AddressTypeEnum {
    BILLING("BILLING"),
    
    RESIDENTIAL("RESIDENTIAL"),
    
    BUSINESS("BUSINESS");

    private String value;

    AddressTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AddressTypeEnum fromValue(String text) {
      for (AddressTypeEnum b : AddressTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("address_type")
  private AddressTypeEnum addressType = null;

  @JsonProperty("address1")
  private String address1 = null;

  @JsonProperty("address2")
  private String address2 = null;

  @JsonProperty("suburb")
  private String suburb = null;

  @JsonProperty("postcode")
  private Integer postcode = null;

  /**
   * Gets or Sets state
   */
  public enum StateEnum {
    ACT("ACT"),
    
    NSW("NSW"),
    
    VIC("VIC"),
    
    QLD("QLD"),
    
    SA("SA");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("state")
  private StateEnum state = null;

  public AddressData addressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
    return this;
  }

  /**
   * Get addressType
   * @return addressType
  **/
  @ApiModelProperty(value = "")

  public AddressTypeEnum getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
  }

  public AddressData address1(String address1) {
    this.address1 = address1;
    return this;
  }

  /**
   * Get address1
   * @return address1
  **/
  @ApiModelProperty(value = "")

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public AddressData address2(String address2) {
    this.address2 = address2;
    return this;
  }

  /**
   * Get address2
   * @return address2
  **/
  @ApiModelProperty(value = "")

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public AddressData suburb(String suburb) {
    this.suburb = suburb;
    return this;
  }

  /**
   * Get suburb
   * @return suburb
  **/
  @ApiModelProperty(value = "")

  public String getSuburb() {
    return suburb;
  }

  public void setSuburb(String suburb) {
    this.suburb = suburb;
  }

  public AddressData postcode(Integer postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   * Get postcode
   * @return postcode
  **/
  @ApiModelProperty(value = "")

  public Integer getPostcode() {
    return postcode;
  }

  public void setPostcode(Integer postcode) {
    this.postcode = postcode;
  }

  public AddressData state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")

  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressData addressData = (AddressData) o;
    return Objects.equals(this.addressType, addressData.addressType) &&
        Objects.equals(this.address1, addressData.address1) &&
        Objects.equals(this.address2, addressData.address2) &&
        Objects.equals(this.suburb, addressData.suburb) &&
        Objects.equals(this.postcode, addressData.postcode) &&
        Objects.equals(this.state, addressData.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressType, address1, address2, suburb, postcode, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressData {\n");
    
    sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
    sb.append("    address1: ").append(toIndentedString(address1)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    suburb: ").append(toIndentedString(suburb)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
