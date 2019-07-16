package com.magere.livedataexample.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String
)