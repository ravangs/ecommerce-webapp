package com.ooad.ecommerce.views;

import com.ooad.ecommerce.model.User;
import com.ooad.ecommerce.security.AuthenticatedUser;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.Optional;

/** The main view is a top-level placeholder for other views. */
@SuppressWarnings("ALL")
public class MainLayout extends AppLayout {

  private H1 appName;

  private AuthenticatedUser authenticatedUser;
  private AccessAnnotationChecker accessChecker;

  public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
    this.authenticatedUser = authenticatedUser;
    this.accessChecker = accessChecker;

    setPrimarySection(Section.DRAWER);
    //    addDrawerContent();
    addHeaderContent();
  }

  private void addHeaderContent() {

    appName = new H1("Buffkart");
    appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE, "header-color");

    addToNavbar(true, appName, createFooter());
  }

  private Footer createFooter() {
    Footer layout = new Footer();
    layout.addClassNames("user-icon");

    Optional<User> maybeUser = authenticatedUser.get();
    if (maybeUser.isPresent()) {
      User user = maybeUser.get();

      Avatar avatar = new Avatar(user.getUserName());

      avatar.setThemeName("xsmall");
      avatar.getElement().setAttribute("tabindex", "-1");

      MenuBar userMenu = new MenuBar();
      userMenu.setThemeName("tertiary-inline contrast");

      MenuItem userName = userMenu.addItem("");
      Div div = new Div();
      div.add(avatar);
      div.add(user.getUserName());
      div.add(new Icon("lumo", "dropdown"));
      div.getElement().getStyle().set("display", "flex");
      div.getElement().getStyle().set("align-items", "center");
      div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
      userName.add(div);
      userName
          .getSubMenu()
          .addItem(
              "Sign out",
              e -> {
                authenticatedUser.logout();
              });

      layout.add(userMenu);
    } else {
      Anchor loginLink = new Anchor("login", "Sign in");
      layout.add(loginLink);
    }

    return layout;
  }

  @Override
  protected void afterNavigation() {
    super.afterNavigation();
    //    viewTitle.setText(getCurrentPageTitle());
  }

  private String getCurrentPageTitle() {
    PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
    return title == null ? "" : title.value();
  }
}
