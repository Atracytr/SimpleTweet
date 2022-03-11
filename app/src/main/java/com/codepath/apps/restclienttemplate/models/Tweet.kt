package com.codepath.apps.restclienttemplate.models

import com.codepath.apps.restclienttemplate.models.User.Companion.fromJson
import org.json.JSONArray
import org.json.JSONObject

class Tweet {

    var body: String = ""
    var createdAt: String = ""
    var user: User? = null


    companion object {

        fun getFormattedTimestamp(createdAt : String): String {
            return TimeFormatter.getTimeDifference(createdAt)
        }

        fun fromJson(jsonObject: JSONObject) : Tweet {
            val tweet = Tweet()
            tweet.body = jsonObject.getString("text")
            tweet.createdAt = getFormattedTimestamp(jsonObject.getString("created_at"))
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"))
            return tweet
        }

        fun fromJsonArray(jsonArray: JSONArray): List<Tweet> {
            val tweets = ArrayList<Tweet>()
            for (i in 0 until jsonArray.length()) {
                tweets.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return tweets




        }
    }
}