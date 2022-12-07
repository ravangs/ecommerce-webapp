package com.ooad.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_info", schema = "ecommerce")
public class UserInfo {
  @Id
  @Column(name = "user_id", nullable = false)
  private Integer id;

  @Size(max = 63)
  @NotNull
  @Column(name = "first_name", nullable = false, length = 63)
  private String firstName;

  @Size(max = 63)
  @NotNull
  @Column(name = "last_name", nullable = false, length = 63)
  private String lastName;

  @Size(max = 127)
  @NotNull
  @Column(name = "mail_id", nullable = false, length = 127)
  private String mailId;

  @NotNull
  @Column(name = "shipping_address", nullable = false)
  private byte[] shippingAddress;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMailId() {
    return mailId;
  }

  public void setMailId(String mailId) {
    this.mailId = mailId;
  }

  public byte[] getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(byte[] shippingAddress) {
    this.shippingAddress = shippingAddress;
  }
}
