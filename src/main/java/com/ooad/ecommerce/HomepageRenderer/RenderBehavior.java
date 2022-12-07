package com.ooad.ecommerce.HomepageRenderer;

import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.Component;

public interface RenderBehavior {
  Component renderHomepage(AuthService authService, CatalogController catalogController);
}
