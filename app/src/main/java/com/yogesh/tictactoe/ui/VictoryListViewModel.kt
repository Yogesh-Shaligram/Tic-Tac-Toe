package com.yogesh.tictactoe.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.yogesh.tictactoe.data.Victory
import com.yogesh.tictactoe.data.VictoryListRepository

class VictoryListViewModel(application: Application): AndroidViewModel(application) {

    private val repo: VictoryListRepository =
        VictoryListRepository(application)

    val players: LiveData<List<Victory>>
    get() = repo.getPlayers()

}