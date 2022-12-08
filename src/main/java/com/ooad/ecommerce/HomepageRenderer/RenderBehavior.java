package com.ooad.ecommerce.HomepageRenderer;

import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.Component;

// This is an example of Strategy Pattern
// This interface is the Algorithm Class in the pattern
public interface RenderBehavior {
  Component renderHomepage(AuthService authService, CatalogController catalogController);
}
