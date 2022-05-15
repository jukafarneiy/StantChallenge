package curso.kotlin.stantchallengetest.data.networking

import curso.kotlin.stantchallengetest.data.models.MovieListResponseData
import curso.kotlin.stantchallengetest.data.services.MovieApiBuilder
import curso.kotlin.stantchallengetest.data.services.MovieService

class ApiHelper {

    suspend fun getMovies(page: Int): MovieListResponseData {
        val apiService = MovieApiBuilder.getInstance().create(MovieService::class.java)

        return apiService.getMovieList(page = page)
    }
}