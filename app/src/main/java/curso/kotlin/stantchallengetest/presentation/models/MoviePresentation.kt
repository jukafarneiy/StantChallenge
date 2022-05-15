package curso.kotlin.stantchallengetest.presentation.models

import java.io.Serializable

data class MoviePresentation(
    val title: String,
    val id: String,
    val imageRelativeUrl: String,
    val genres: List<String>,
    val releaseDate: String
): Serializable