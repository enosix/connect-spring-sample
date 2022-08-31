package io.enosix.connect.dtos.enosixCustomerSearch.response;

import io.enosix.connect.dtos.PagingInfo;

import java.util.ArrayList;

public class EnosixCustomerSearchResponse {
    public ArrayList<Result> results;
    public PagingInfo pagingInfo;
    public ArrayList<Message> messages;
    public boolean success;
}
