package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ItemImageResponse : Serializable {
    @SerializedName("status")
    @Expose
    var isStatus = false

    @SerializedName("message")
    @Expose
    var message: Any? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    class Data : Serializable {
        @SerializedName("users")
        @Expose
        var users: ArrayList<User>? = null

        @SerializedName("has_more")
        @Expose
        var isHasMore = false

        class User : Serializable {
            @SerializedName("name")
            @Expose
            var name: String? = null

            @SerializedName("image")
            @Expose
            var image: String? = null

            @SerializedName("items")
            @Expose
            var items: ArrayList<String>? = null

        }
    }

}