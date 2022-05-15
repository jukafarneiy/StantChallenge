package curso.kotlin.stantchallengetest.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import curso.kotlin.stantchallengetest.data.repository.MovieRepository
import curso.kotlin.stantchallengetest.presentation.viewmodel.ListMovieViewModel


class ListMovieModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListMovieViewModel(movieRepository) as T
    }
}