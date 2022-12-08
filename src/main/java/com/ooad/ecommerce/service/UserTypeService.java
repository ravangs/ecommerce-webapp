package com.ooad.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTypeService {

  List<String> userTypes = new ArrayList<>();

  public UserTypeService() {
    userTypes.add("Vendor");
    userTypes.add("Customer");
  }
  public List<String> getUserTypes() {
    return userTypes;
  }
}
