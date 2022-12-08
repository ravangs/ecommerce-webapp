package com.ooad.ecommerce.views.login;

import com.ooad.ecommerce.security.AuthenticatedUser;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
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
    lf.setForgotPasswordButtonVisible(false);

    Div separator = new Div(new Paragraph("OR"));

    Button signUpButton = new Button("Create an Account");
    signUpButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    // This is an example of Observer pattern as we are observing the click event
    signUpButton.addClickListener(
        event -> {
          // This is an example of command pattern as we are assigning a command to the click event
          UI.getCurrent().navigate("sign-up");
        });

    add(lf, separator, signUpButton);
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
