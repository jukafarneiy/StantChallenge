package curso.kotlin.stantchallengetest.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import curso.kotlin.stantchallengetest.databinding.ActivityMovieDetailsBinding
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val movie = intent.getSerializableExtra("movie") as MoviePresentation

        binding.movieTitleTextView.text = movie.title
        binding.genreTextView.text = movie.genres.toString()
        binding.movieReleaseDataTextView.text = movie.releaseDate

        Glide.with(binding.imageMovieDetail)
            .load(BASE_IMAGE_URL.plus(movie.imageRelativeUrl))
            .into(binding.imageMovieDetail)

    }

    companion object {
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}

