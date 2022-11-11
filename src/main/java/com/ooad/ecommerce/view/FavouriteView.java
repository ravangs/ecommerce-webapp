package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.FavouriteController;
import com.ooad.ecommerce.dto.FavouriteDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class FavouriteView extends FavouriteController {

    private List<FavouriteDto> getFavourites(){

    }

    private boolean updateFavourites(){

    }

}
