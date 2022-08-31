package io.enosix.connect.dtos;

import io.enosix.connect.dtos.SortField;

import java.util.ArrayList;

public class PagingInfo {
    public int totalRecords;
    public int pageSize;
    public int pageNumber;
    public ArrayList<SortField> sortFields;
}
