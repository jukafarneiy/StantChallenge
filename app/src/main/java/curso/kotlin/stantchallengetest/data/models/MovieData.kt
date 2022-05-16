package curso.kotlin.stantchallengetest.data.models

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("poster_path") val poster: String?,
    @SerializedName("genre_ids") val genre: List<String>,
    @SerializedName("release_date") val release: String?
)
