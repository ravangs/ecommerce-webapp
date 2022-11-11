package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.User;
import com.ooad.ecommerce.view.LoginView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends LoginView implements Serializable {
    private Integer id;
    @Size(max = 63)
    @NotNull
    private String userName;
    @Size(max = 127)
    @NotNull
    private String password;
    @NotNull
    private String userType;
}