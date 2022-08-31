package io.enosix.connect.dtos.enosixCustomerSearch.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.enosix.connect.dtos.PagingOptions;

import java.util.ArrayList;

public class EnosixCustomerSearchRequest {
    public SearchParams searchparams;
    @JsonProperty("contacT_PERSON")
    public ContactPerson contactPerson;
    @JsonProperty("accounT_GROUPS")
    public ArrayList<AccountGroup> accountGroups;
    public PagingOptions pagingOptions;
}
