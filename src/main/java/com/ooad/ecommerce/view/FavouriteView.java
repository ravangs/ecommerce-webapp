package com.ooad.ecommerce.view;

import com.ooad.ecommerce.dto.FavouriteDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class FavouriteView{

  private List<FavouriteDto> getFavourites() {
    return null;
  }

  private boolean updateFavourites() {
    return false;
  }
}
