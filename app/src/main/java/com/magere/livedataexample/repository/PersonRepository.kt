package com.magere.livedataexample.repository

import android.app.Application
import android.app.Person
import androidx.lifecycle.LiveData
import com.magere.livedataexample.data.db.Database
import com.magere.livedataexample.data.db.PersonEntity
import com.magere.livedataexample.data.db.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PersonRepository(application: Application) {

    private val db = Database.getInstance(application)
    private val personsDao = db?.personsDao()
    private var allPersons: LiveData<List<PersonEntity>>? = personsDao?.loadAllPersons()

    fun insertPerson(person: PersonEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            personsDao?.insertPerson(PersonEntity(null, "Andrey"))
        }
    }

    fun upatePerson(person: PersonEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            personsDao?.updatePerson(PersonEntity(3, "Dima"))
        }
    }

    fun deletePerson(person: PersonEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            personsDao?.deletePerson(3)
        }
    }

    fun getAllPersons(): LiveData<List<PersonEntity>>? {
        return allPersons
    }

}