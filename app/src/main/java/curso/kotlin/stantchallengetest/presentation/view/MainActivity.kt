package curso.kotlin.stantchallengetest.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import curso.kotlin.stantchallengetest.databinding.ActivityMainBinding
import curso.kotlin.stantchallengetest.data.repository.MovieRepository
import curso.kotlin.stantchallengetest.presentation.adapter.MovieAdapter
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MovieAdapter.OnClickItem {

    private lateinit var binding: ActivityMainBinding

    private val repository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)

        repository.getMovies {
            rv_movies_list.adapter = MovieAdapter(it, this)
        }

    }

    override fun onClick(movie: MoviePresentation) {
        startActivity(Intent(this, MovieDetailsActivity::class.java))
    }
}