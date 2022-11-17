package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.FavouriteDto;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;

  private List<FavouriteDto> getFavouriteDetails() {
    return null;
  }

  private void updateFavouriteDetails() {}
}
