package curso.kotlin.stantchallengetest.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import curso.kotlin.stantchallengetest.R
import curso.kotlin.stantchallengetest.data.repository.MovieRepository

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}