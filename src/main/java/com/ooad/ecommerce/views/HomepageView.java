package com.ooad.ecommerce.views;

import com.ooad.ecommerce.HomepageRenderer.CustomerHomepageRenderer;
import com.ooad.ecommerce.HomepageRenderer.VendorHomepageRenderer;
import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import javax.annotation.security.PermitAll;

@Route
@PageTitle("Buffkart - Home")
@RouteAlias(value = "", layout = MainLayout.class)
@PermitAll
public class HomepageView extends HorizontalLayout {
  public HomepageView( AuthService authService, CatalogController catalogController) {
    if (authService.getUserType().equals("vendor")) {
      add(new ProductCatalogView(authService, catalogController, new VendorHomepageRenderer()));
    } else {
      add(new ProductCatalogView(authService, catalogController, new CustomerHomepageRenderer()));
    }
  }
}
