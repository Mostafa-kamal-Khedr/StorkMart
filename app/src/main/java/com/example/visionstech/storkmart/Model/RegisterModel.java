package com.example.visionstech.storkmart.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sas on 11/01/2018.
 */

public class RegisterModel {


    /**
     * message_ar : تم التسجيل بنجاح
     * message_en : Registered  successfully
     * user : {"id":32,"image":"","name":"mm","email":"aa@gmail.com","phone":"123456789","status":1,"device_token":"1","device_typassworde":"1","lat":"1","lng":"1","type":{"type_ar":"إدارة","type_en":"Admin"},"created_at":"2018-01-11"}
     * success : yes
     */

    @SerializedName("message_ar")
    private String messageAr;
    @SerializedName("message_en")
    private String messageEn;
    @SerializedName("user")
    private UserBean user;
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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public static class UserBean {
        /**
         * id : 32
         * image :
         * name : mm
         * email : aa@gmail.com
         * phone : 123456789
         * status : 1
         * device_token : 1
         * device_type : 1
         * lat : 1
         * lng : 1
         * type : {"type_ar":"إدارة","type_en":"Admin"}
         * created_at : 2018-01-11
         */

        @SerializedName("id")
        private int id;
        @SerializedName("image")
        private String image;
        @SerializedName("name")
        private String name;
        @SerializedName("email")
        private String email;
        @SerializedName("phone")
        private String phone;
        @SerializedName("status")
        private int status;
        @SerializedName("device_token")
        private String deviceToken;
        @SerializedName("device_type")
        private String deviceType;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;
        @SerializedName("type")
        private TypeBean type;
        @SerializedName("created_at")
        private String createdAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public static class TypeBean {
            /**
             * type_ar : إدارة
             * type_en : Admin
             */

            @SerializedName("type_ar")
            private String typeAr;
            @SerializedName("type_en")
            private String typeEn;

            public String getTypeAr() {
                return typeAr;
            }

            public void setTypeAr(String typeAr) {
                this.typeAr = typeAr;
            }

            public String getTypeEn() {
                return typeEn;
            }

            public void setTypeEn(String typeEn) {
                this.typeEn = typeEn;
            }
        }
    }
}
