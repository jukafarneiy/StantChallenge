package curso.kotlin.stantchallengetest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import curso.kotlin.stantchallengetest.databinding.MovieItemBinding
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation

class MovieAdapter(
    private val onClickItem: OnClickItem
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    val movies: MutableList<MoviePresentation> = mutableListOf()

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: MoviePresentation, onClickItem: OnClickItem) {
            binding.movieTitleTextView.text = movie.title
            binding.genreTextView.text = movie.genres.toString()
            binding.movieReleaseDataTextView.text = movie.releaseDate

            Glide.with(binding.moviePosterImageView)
                .load(BASE_IMAGE_URL.plus(movie.imageRelativeUrl))
                .into(binding.moviePosterImageView)

            binding.root.setOnClickListener {
                onClickItem.onClick(movie)
            }
        }

        companion object {
            private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position], onClickItem)
    }

    override fun getItemCount(): Int = movies.size

    interface OnClickItem {
        fun onClick(movie: MoviePresentation)
    }
}

