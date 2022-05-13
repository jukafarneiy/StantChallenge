package curso.kotlin.stantchallengetest.data.services

import curso.kotlin.stantchallengetest.data.models.MovieListResponseData
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("/3/movie/popular?api_key=f321a808e68611f41312aa8408531476")
    fun getMovieList (): Call<MovieListResponseData>
}