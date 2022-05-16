package curso.kotlin.stantchallengetest.presentation.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import curso.kotlin.stantchallengetest.data.repository.MovieRepository
import curso.kotlin.stantchallengetest.databinding.ActivityMainBinding
import curso.kotlin.stantchallengetest.domain.Status
import curso.kotlin.stantchallengetest.presentation.adapter.MovieAdapter
import curso.kotlin.stantchallengetest.presentation.extensions.EndlessRecyclerOnScrollListener
import curso.kotlin.stantchallengetest.presentation.factory.ListMovieModelFactory
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation
import curso.kotlin.stantchallengetest.presentation.viewmodel.ListMovieViewModel


class ListMovieActivity : AppCompatActivity(), MovieAdapter.OnClickItem {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListMovieViewModel by viewModels {
        ListMovieModelFactory(MovieRepository())
    }
    private val adapter = MovieAdapter(this)

    private val linearLayout = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.rvMoviesList.layoutManager = linearLayout
        binding.rvMoviesList.setHasFixedSize(true)
        binding.rvMoviesList.adapter = adapter

        observeMovies()
        viewModel.loadMovies()

        paginationRecyclerView()
    }

    private fun paginationRecyclerView() {
        binding.rvMoviesList.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener(linearLayout, 5) {
            override fun onLoadMore() {
                viewModel.loadMovies()
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeMovies() {
        viewModel.getMovies().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    adapter.movies.addAll(it.data ?: emptyList())
                    adapter.notifyDataSetChanged()
                }
                Status.ERROR -> {}
                Status.LOADING -> {}
            }
        }

    }

    override fun onClick(movie: MoviePresentation) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

}

