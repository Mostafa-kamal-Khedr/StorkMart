package com.example.visionstech.storkmart.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sas on 15/01/2018.
 */

public class ForgetPasswordResponse {


    /**
     * message_ar :  تم إرسال بريد إلكترونى
     * message_en : Email sent successfully
     * success : yes
     */

    @SerializedName("message_ar")
    private String messageAr;
    @SerializedName("message_en")
    private String messageEn;
    @SerializedName("success")
    private String success;

    public String getMessageAr() {
        return messageAr;
    }

    public void setMessageAr(String messageAr) {
        this.messageAr = messageAr;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
