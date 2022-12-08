package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.LoginController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.SignUpDto;
import com.ooad.ecommerce.service.UserTypeService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;



@PageTitle("Buffkart - Sign Up")
@Route(value = "sign-up")
@AnonymousAllowed
public class SignUpView extends VerticalLayout {

  Binder<NewUser> binder = new Binder<>();

  NewUser newUser = new NewUser();

  LoginController loginController;
  TextField userName = new TextField("User name");
  PasswordField password = new PasswordField("Password");
  ComboBox<String> userType = new ComboBox<>("User Type");
  TextField firstName = new TextField("First name");
  TextField lastName = new TextField("Last name");
  EmailField mailId = new EmailField("Email");
  TextArea shippingAddress = new TextArea("Shipping Address");

  SignUpView(UserTypeService userTypeService, LoginController loginController) {
    add(new H2("Create an Account"));

    this.loginController = loginController;
    userType.setItems(userTypeService.getUserTypes());

    binder.forField(userName).bind(NewUser::getUserName, NewUser::setUserName);
    binder.forField(password).bind(NewUser::getPassword, NewUser::setPassword);
    binder.forField(userType).bind(NewUser::getUserType, NewUser::setUserType);
    binder.forField(firstName).bind(NewUser::getFirstName, NewUser::setFirstName);
    binder.forField(lastName).bind(NewUser::getLastName, NewUser::setLastName);
    binder.forField(mailId).bind(NewUser::getMailId, NewUser::setMailId);
    binder.forField(shippingAddress).bind(NewUser::getShippingAddress, NewUser::setShippingAddress);



    FormLayout signUpForm = new FormLayout();
    signUpForm.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
    signUpForm.add(userName, password, userType, firstName, lastName, mailId, shippingAddress);

    Button submitForm = new Button("Create");
    submitForm.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    submitForm.addClickListener(
        event -> {
          // This is an example of command pattern as we are assigning a command to the click event
          createUser();
        });

    add(signUpForm, submitForm);
    setWidth("50%");
    setAlignItems(Alignment.CENTER);
    setJustifyContentMode(JustifyContentMode.CENTER);
  }

  public void createUser() {
    try {
      binder.writeBean(newUser);
    } catch (ValidationException e) {
      throw new RuntimeException(e);
    }
    SignUpDto user = createSignUpPayload();
    loginController.signup(user);
    UI.getCurrent().navigate("login");
  }

  public SignUpDto createSignUpPayload() {
    return SignUpDto.builder()
        .userName(newUser.getUserName())
        .password(newUser.getPassword())
        .userType(newUser.getUserType())
        .firstName(newUser.getFirstName())
        .lastName(newUser.getLastName())
        .mailId(newUser.getMailId())
        .shippingAddress(newUser.getShippingAddress().getBytes())
        .build();
  }

}

class NewUser {

  String userName;

  String password;

  String userType;

  String firstName;

  String lastName;

  String mailId;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMailId() {
    return mailId;
  }

  public void setMailId(String mailId) {
    this.mailId = mailId;
  }

  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  String shippingAddress;
}