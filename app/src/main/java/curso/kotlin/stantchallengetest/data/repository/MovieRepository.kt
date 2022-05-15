package curso.kotlin.stantchallengetest.data.repository

import curso.kotlin.stantchallengetest.data.mapper.mapperToDomain
import curso.kotlin.stantchallengetest.data.networking.ApiHelper
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation

class MovieRepository {

    suspend fun getMovies(page: Int): List<MoviePresentation> {
        val movies = ApiHelper().getMovies(page).movies ?: emptyList()
        return movies.map {
            it.mapperToDomain()
        }
    }

}