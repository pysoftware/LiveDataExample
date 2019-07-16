package com.magere.livedataexample.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonsDao {

    @Query("SELECT * FROM persons")
    fun loadAllPersons(): LiveData<List<PersonEntity>>

    @Query("SELECT * FROM persons WHERE id = :id")
    fun loadByPersonId(id: Int): PersonEntity

    @Insert
    fun insertPerson(person: PersonEntity)

    @Update
    fun updatePerson(person: PersonEntity)

    @Query("DELETE FROM persons WHERE id = :id")
    fun deletePerson(id: Long)

}