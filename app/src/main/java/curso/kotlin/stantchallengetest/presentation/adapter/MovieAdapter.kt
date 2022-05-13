package curso.kotlin.stantchallengetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import curso.kotlin.stantchallengetest.R
import curso.kotlin.stantchallengetest.presentation.models.MoviePresentation
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies: List<MoviePresentation>,
    private val onClickItem: OnClickItem
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindMovie(movie: MoviePresentation, onClickItem: OnClickItem) {
            itemView.movieTitleTextView.text = movie.title
            itemView.movieReleaseDataTextView.text = movie.releaseDate
            itemView.genreTextView.text = movie.genreIds

            Glide.with(itemView)
                .load(BASE_IMAGE_URL.plus(movie.imageRelativeUrl))
                .into(itemView.moviePosterImageView)

            itemView.setOnClickListener {
                onClickItem.onClick(movie)
            }
        }

        companion object {
            private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
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

