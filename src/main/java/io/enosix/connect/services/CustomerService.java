package io.enosix.connect.services;

import io.enosix.connect.resources.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers(int pageNumber, int pageSize);
}
