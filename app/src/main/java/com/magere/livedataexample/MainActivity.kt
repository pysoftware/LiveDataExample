package com.magere.livedataexample

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.magere.livedataexample.data.db.Database
import com.magere.livedataexample.data.db.PersonEntity
import com.magere.livedataexample.view_model.PersonViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)
        personViewModel.getAllPersons()?.observe(this, Observer {
            textView.text = "$it"
        })

        addPersonButton.setOnClickListener {
            personViewModel.insert(PersonEntity(null, "CHeck"))
        }

        deletePersonButton.setOnClickListener {
            personViewModel.delete(PersonEntity(null, "CHeck"))
        }
    }
}
