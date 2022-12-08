package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.User;
import com.ooad.ecommerce.model.UserInfo;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto implements Serializable {
  private Integer id;

  @Size(max = 63)
  @NotNull
  private String userName;

  @Size(max = 127)
  @NotNull
  private String password;

  @NotNull private String userType;

  @Size(max = 63)
  @NotNull
  private String firstName;

  @Size(max = 63)
  @NotNull
  private String lastName;

  @Size(max = 127)
  @NotNull
  private String mailId;

  @NotNull private byte[] shippingAddress;

  public User convertToUserEntity() {
    User user = new User();
    user.setUserName(this.userName);
    user.setPassword(this.password);
    user.setUserType(this.userType);
    return user;
  }

  public UserInfo convertToUserInfoEntity() {
    UserInfo userInfo = new UserInfo();
    userInfo.setId(this.id);
    userInfo.setFirstName(this.firstName);
    userInfo.setLastName(this.lastName);
    userInfo.setMailId(this.mailId);
    userInfo.setShippingAddress(this.shippingAddress);
    return userInfo;
  }
}
