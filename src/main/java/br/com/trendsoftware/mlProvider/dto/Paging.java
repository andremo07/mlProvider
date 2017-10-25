package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging {

@SerializedName("limit")
@Expose
private Long limit;
@SerializedName("offset")
@Expose
private Long offset;
@SerializedName("total")
@Expose
private Long total;

public Long getLimit() {
return limit;
}

public void setLimit(Long limit) {
this.limit = limit;
}

public Long getOffset() {
return offset;
}

public void setOffset(Long offset) {
this.offset = offset;
}

public Long getTotal() {
return total;
}

public void setTotal(Long total) {
this.total = total;
}

}