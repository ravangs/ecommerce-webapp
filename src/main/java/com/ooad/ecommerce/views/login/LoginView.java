package com.ooad.ecommerce.views.login;

import com.ooad.ecommerce.security.AuthenticatedUser;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Buffkart - Login")
@Route(value = "login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

  private final AuthenticatedUser authenticatedUser;
  LoginForm lf = new LoginForm();

  public LoginView(AuthenticatedUser authenticatedUser) {
    this.authenticatedUser = authenticatedUser;

    add(lf);
    setSizeFull();
    setAlignItems(Alignment.CENTER);
    setJustifyContentMode(JustifyContentMode.CENTER);
    lf.setAction("login");
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if (event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
      lf.setError(true);
    }
    if (authenticatedUser.get().isPresent()) {
      event.forwardTo("vendor");
    }
  }
}
