package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.OrderController;
import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;

@PageTitle("Buffkart - Order History")
// The definition of layout is an example of composite pattern
// as the UI is generated in a tree fashion with MainLayout as the root
@Route(value = "order-history", layout = MainLayout.class)
@PermitAll
public class OrderHistoryView extends VerticalLayout {
  public OrderHistoryView(OrderController orderController, AuthService authService) {

    add(new H2("Order History"));
    List<Order> orders = orderController.getOrders(authService.getUserId());
    for (Order order : orders) {
      add(createOrderItem(order));
    }
  }

  public Component createOrderItem(Order order) {
    Paragraph orderId = new Paragraph("Order Id: " + order.getId());
    orderId.addClassName("order-item-info");

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
    String formattedDate = formatter.format(Date.from(order.getOrderDate()));
    Paragraph orderDate = new Paragraph("Order Date: " + formattedDate);
    orderDate.addClassName("order-item-info");

    Paragraph orderTotal = new Paragraph("Total: " + order.getTotalCost());
    orderTotal.addClassName("order-item-info");

    Div orderItem = new Div();
    orderItem.addClassName("order-item");
    orderItem.add(orderId, orderDate, orderTotal);
    orderItem.addClickListener(
        event -> {
          UI.getCurrent().navigate("order/" + order.getId());
        });

    return orderItem;
  }
}
