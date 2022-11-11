package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.CartController;
import com.ooad.ecommerce.dto.CartDto;
import com.ooad.ecommerce.service.RestClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class CartView extends CartController {

    private List<CartDto> getCartDetails(){

    }

    private boolean putCartDetails(){

    }

}
