
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingInfo {

    @SerializedName("doc_type")
    @Expose
    private Object docType;
    @SerializedName("doc_number")
    @Expose
    private Object docNumber;

    public Object getDocType() {
        return docType;
    }

    public void setDocType(Object docType) {
        this.docType = docType;
    }

    public Object getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Object docNumber) {
        this.docNumber = docNumber;
    }

}
