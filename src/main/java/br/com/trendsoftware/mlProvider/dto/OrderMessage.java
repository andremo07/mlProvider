
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderMessage {

    @SerializedName("message_id")
    @Expose
    private String messageId;
    @SerializedName("date_received")
    @Expose
    private String dateReceived;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_available")
    @Expose
    private String dateAvailable;
    @SerializedName("date_notified")
    @Expose
    private String dateNotified;
    @SerializedName("date_read")
    @Expose
    private String dateRead;
    @SerializedName("from")
    @Expose
    private From from;
    @SerializedName("to")
    @Expose
    private List<To> to = null;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("attachments")
    @Expose
    private List<Attachment> attachments = null;
    @SerializedName("attachments_validations")
    @Expose
    private AttachmentsValidations attachmentsValidations;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("resource_id")
    @Expose
    private String resourceId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("moderation")
    @Expose
    private Moderation moderation;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getDateNotified() {
        return dateNotified;
    }

    public void setDateNotified(String dateNotified) {
        this.dateNotified = dateNotified;
    }

    public String getDateRead() {
        return dateRead;
    }

    public void setDateRead(String dateRead) {
        this.dateRead = dateRead;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public List<To> getTo() {
        return to;
    }

    public void setTo(List<To> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public AttachmentsValidations getAttachmentsValidations() {
        return attachmentsValidations;
    }

    public void setAttachmentsValidations(AttachmentsValidations attachmentsValidations) {
        this.attachmentsValidations = attachmentsValidations;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Moderation getModeration() {
        return moderation;
    }

    public void setModeration(Moderation moderation) {
        this.moderation = moderation;
    }

}
