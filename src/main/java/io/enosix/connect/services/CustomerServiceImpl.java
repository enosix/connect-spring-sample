package io.enosix.connect.services;

import io.enosix.connect.dtos.PagingOptions;
import io.enosix.connect.dtos.enosixCustomerSearch.request.EnosixCustomerSearchRequest;
import io.enosix.connect.dtos.enosixCustomerSearch.response.EnosixCustomerSearchResponse;
import io.enosix.connect.resources.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final RestTemplate restTemplate;
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Customer> getCustomers(int pageNumber, int pageSize) {
        var customerSearchRequest = new EnosixCustomerSearchRequest();
        customerSearchRequest.pagingOptions = new PagingOptions();

        ResponseEntity<EnosixCustomerSearchResponse> response = restTemplate.postForEntity("/api/sap/SAP/EnosixCustomer/search",
                customerSearchRequest,
                EnosixCustomerSearchResponse.class);
        if(!response.getStatusCode().is2xxSuccessful()) {
            logger.info("Request to get customers threw failed with status code {}", response.getStatusCode().value());
            return List.of();
        }
        return Objects.requireNonNull(response.getBody()).results
                .stream()
                .map(r -> new Customer(
                        r.name,
                        r.customerNumber,
                        r.city,
                        r.region,
                        r.countryKey
                ))
                .collect(Collectors.toList());
    }
}
