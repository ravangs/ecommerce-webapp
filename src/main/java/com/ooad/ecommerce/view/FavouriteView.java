package com.ooad.ecommerce.view;

import com.ooad.ecommerce.dto.FavouriteDto;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class FavouriteView {

  private List<FavouriteDto> getFavourites() {
    return null;
  }

  private boolean updateFavourites() {
    return false;
  }
}
