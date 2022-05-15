package curso.kotlin.stantchallengetest.data.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieApiBuilder {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org"

        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
                val client: OkHttpClient =
                    OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }

}