package curso.kotlin.stantchallengetest.data.services

import curso.kotlin.stantchallengetest.data.models.MovieListResponseData
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = "f321a808e68611f41312aa8408531476",
        @Query("page") page: Int
    ): MovieListResponseData
}