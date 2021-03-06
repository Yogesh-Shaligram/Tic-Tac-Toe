package com.yogesh.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogesh.tictactoe.R
import kotlinx.android.synthetic.main.fragment_leaderboard.*


class LeaderboardFragment : Fragment() {

    private lateinit var viewModel: VictoryListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(VictoryListViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Setting up recycler view
        val layoutmanager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        leaderboardView.apply {
            layoutManager = layoutmanager
            adapter = LeaderboardAdapter {}
        }

        // Observing Live Data for recycler view
        viewModel.players.observe(viewLifecycleOwner, Observer {
            (leaderboardView.adapter as LeaderboardAdapter).submitList(it)
        })


    }

}