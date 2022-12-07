package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.User;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link User} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {
  private Integer id;

  @Size(max = 63)
  @NotNull
  private String userName;

  @Size(max = 127)
  @NotNull
  private String password;

  @NotNull private String userType;
}
