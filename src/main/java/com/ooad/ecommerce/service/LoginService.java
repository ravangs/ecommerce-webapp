package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.SignUpDto;
import com.ooad.ecommerce.model.User;
import com.ooad.ecommerce.model.UserInfo;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;

  public UserInfo signup(SignUpDto userDetails) {
    User user = userRepository.save(userDetails.convertToUserEntity());
    userDetails.setId(user.getId());
    return userInfoRepository.save(userDetails.convertToUserInfoEntity());
  }
}
