package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.UserInfo;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link UserInfo} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto implements Serializable {
  private Integer id;

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
}
