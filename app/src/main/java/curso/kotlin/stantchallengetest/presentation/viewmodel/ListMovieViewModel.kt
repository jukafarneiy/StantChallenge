package curso.kotlin.stantchallengetest.presentation.viewmodel

import androidx.lifecycle.*
import curso.kotlin.stantchallengetest.data.repository.MovieRepository
import curso.kotlin.stantchallengetest.domain.Resource
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation
import kotlinx.coroutines.launch

class ListMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var currentPage = 0

    private val movies: MutableLiveData<Resource<List<MoviePresentation>>> =
        MutableLiveData<Resource<List<MoviePresentation>>>()

    fun getMovies(): LiveData<Resource<List<MoviePresentation>>> {
        return movies
    }

    fun loadMovies() {
        currentPage++

        movies.postValue(Resource.loading(data = null))
        viewModelScope.launch {
            try {
                movies.postValue(Resource.success(data = movieRepository.getMovies(currentPage)))
            } catch (exception: Exception) {
                movies.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!"
                    )
                )
            }
        }
    }

}