package com.ooad.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

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
