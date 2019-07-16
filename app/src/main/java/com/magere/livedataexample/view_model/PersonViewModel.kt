package com.magere.livedataexample.view_model

import android.app.Application
import android.app.Person
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.magere.livedataexample.data.db.Database
import com.magere.livedataexample.data.db.PersonEntity
import com.magere.livedataexample.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository(application)
    private var allPersons: LiveData<List<PersonEntity>>? = personRepository.getAllPersons()

    fun insert(person: PersonEntity) {
        personRepository.insertPerson(person)
    }

    fun update(person: PersonEntity) {
        personRepository.upatePerson(person)
    }

    fun delete(person: PersonEntity) {
        personRepository.deletePerson(person)
    }

    fun getAllPersons(): LiveData<List<PersonEntity>>? {
        return allPersons
    }
}