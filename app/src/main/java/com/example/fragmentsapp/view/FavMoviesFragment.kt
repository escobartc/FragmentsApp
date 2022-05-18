package com.example.fragmentsapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsapp.MovieAdapter
import com.example.fragmentsapp.OnMovieListener
import com.example.fragmentsapp.R
import com.example.fragmentsapp.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_movies.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoggedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavMoviesFragment : Fragment(R.layout.fragment_favorites), View.OnClickListener, OnMovieListener {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            callback
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_fav_movie_list.layoutManager = LinearLayoutManager(requireContext())
        rv_fav_movie_list.setHasFixedSize(true)
        val activity = (requireActivity() as MoviesActivity)
        activity.movieViewModel.favoriteMovies.observe(requireActivity()){
            rv_fav_movie_list.adapter = MovieAdapter(it, this )
        }
    }

    companion object {

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onMovieFavoriteClicked(movie: Movie) {
        TODO("Not yet implemented")
    }
}