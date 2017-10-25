
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentsValidations {

    @SerializedName("invalid_size")
    @Expose
    private List<Object> invalidSize = null;
    @SerializedName("invalid_extension")
    @Expose
    private List<Object> invalidExtension = null;
    @SerializedName("forbidden")
    @Expose
    private List<Object> forbidden = null;
    @SerializedName("internal_error")
    @Expose
    private List<Object> internalError = null;

    public List<Object> getInvalidSize() {
        return invalidSize;
    }

    public void setInvalidSize(List<Object> invalidSize) {
        this.invalidSize = invalidSize;
    }

    public List<Object> getInvalidExtension() {
        return invalidExtension;
    }

    public void setInvalidExtension(List<Object> invalidExtension) {
        this.invalidExtension = invalidExtension;
    }

    public List<Object> getForbidden() {
        return forbidden;
    }

    public void setForbidden(List<Object> forbidden) {
        this.forbidden = forbidden;
    }

    public List<Object> getInternalError() {
        return internalError;
    }

    public void setInternalError(List<Object> internalError) {
        this.internalError = internalError;
    }

}
