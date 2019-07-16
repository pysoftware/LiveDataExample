package com.magere.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.magere.livedataexample.data.db.Database
import com.magere.livedataexample.data.db.PersonEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Database.getInstance(this)
        val personsDao = db?.personsDao()

        db?.personsDao()?.loadAllPersons()?.observe(this, Observer {
            textView.text = "$it"
        })

        addPersonButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                personsDao?.insertPerson(PersonEntity(null, "Andrey"))
            }
        }

        deletePersonButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                personsDao?.deletePerson(7)
            }
        }
    }
}
