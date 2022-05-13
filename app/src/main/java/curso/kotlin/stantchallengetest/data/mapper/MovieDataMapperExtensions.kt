package curso.kotlin.stantchallengetest.data.mapper

import curso.kotlin.stantchallengetest.data.models.MovieData
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation

fun MovieData.mapperToDomain(): MoviePresentation {
    return MoviePresentation(
        id = id ?: "",
        title = title ?: "",
        imageRelativeUrl = poster ?: "",
        releaseDate = release ?: "",
        genreIds = genre ?: ""
    )
}