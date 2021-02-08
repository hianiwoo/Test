package com.test.domain.models

import android.os.Build
import android.os.Parcelable
import android.text.Html
import android.text.Spanned
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    @SerializedName("screenImage") val screenImage: List<String>,
    @SerializedName("rating") val rating: Int,
    @SerializedName("votes") val votes: Int,
    @SerializedName("description") val description: String,
    @SerializedName("isFavorite") val isFavorite: Int,
    @SerializedName("title") val title: String,
    @SerializedName("count") val count: String,
    @SerializedName("timer") val timer: String,
    @SerializedName("director") val director: String,
    @SerializedName("urlImagePreview") val urlImagePreview: String,
    @SerializedName("year") val year: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isLikes") val isLikes: Int
) : Parcelable {
    val ruTitle: String
        get() {
            val indexEnd = title.indexOfFirst { it == '/' }
            return title.substring(0, indexEnd)
        }

    val descriptionHtml: Spanned
        get() {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(description)
            }
        }
}