package curso.kotlin.stantchallengetest.data.models

import com.google.gson.annotations.SerializedName

data class MovieListResponseData(
    @SerializedName("results") val movies: List<MovieData>?
)