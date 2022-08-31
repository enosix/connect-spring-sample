package io.enosix.connect.dtos;

import java.util.ArrayList;

public class PagingOptions {
    public int pageSize = 100;
    public int pageNumber = 1;
    public ArrayList<SortField> sortFields = new ArrayList<>();
}
