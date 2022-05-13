package curso.kotlin.stantchallengetest.data.repository

import curso.kotlin.stantchallengetest.data.mapper.mapperToDomain
import curso.kotlin.stantchallengetest.data.models.MovieListResponseData
import curso.kotlin.stantchallengetest.data.services.MovieApiBuilder
import curso.kotlin.stantchallengetest.data.services.MovieService
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    fun getMovies(onSuccess: (List<MoviePresentation>) -> Unit) {
        val apiService = MovieApiBuilder.getInstance().create(MovieService::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieListResponseData> {
            override fun onResponse(
                call: Call<MovieListResponseData>,
                response: Response<MovieListResponseData>
            ) {
                val moviesDomain = response.body()?.movies?.map {
                    it.mapperToDomain()
                }
                onSuccess(moviesDomain ?: emptyList())
            }

            override fun onFailure(call: Call<MovieListResponseData>, t: Throwable) {

            }
        })
    }

}