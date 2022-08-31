package io.enosix.connect.controllers;

import io.enosix.connect.resources.Customer;
import io.enosix.connect.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public String getCustomersList(@RequestParam(name="page", required=false, defaultValue = "1") int page, Model model) {
        List<Customer> customers = this.customerService.getCustomers(page, 100);
        model.addAttribute("customers", customers);
        return "index";
    }
}
