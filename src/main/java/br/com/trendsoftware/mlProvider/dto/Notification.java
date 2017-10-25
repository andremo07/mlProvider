
package br.com.trendsoftware.mlProvider.dto;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("user_id")
    @Expose
    private Long userId;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("received")
    @Expose
    private Date received;
    @SerializedName("sent")
    @Expose
    private Date sent;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

}
