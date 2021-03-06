package com.yogesh.tictactoe.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "victory")
data class Victory (@PrimaryKey(autoGenerate = true) val id: Long,
                    val name: String, // stores player name
                    val totalGamesPlayed: Int, // stores total number of games played
                    val totalGamesWon: Int // stores total number of games won
)