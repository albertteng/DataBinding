package com.sample.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sample.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingSource:ActivityMainBinding
    private var person:Person = Person("Albert","123456","albert@gmail.com","123 Jalan ABC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingSource = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindingSource.personData = person

        /*
        bindingSource.tvName.text = person.name
        bindingSource.tvNRIC.text = person.ic
        bindingSource.tvEmail.text = person.email
        bindingSource.tvAddress.text = person.address
        */
        bindingSource.btnUpdate.setOnClickListener(){
            person.email = "xyz@gmail.com";
            bindingSource.apply { invalidateAll() }
        }

    }
}