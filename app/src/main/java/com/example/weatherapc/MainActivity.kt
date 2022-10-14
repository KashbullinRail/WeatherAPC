package com.example.weatherapc


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.weatherapc.feature.mainscreen.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity() : AppCompatActivity() {

    private val bottomNavigationMenu: BottomNavigationView by lazy { findViewById(R.id.bnvBar) }
//    private val spCity: Spinner by lazy { findViewById(R.id.spCity2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment())
            .commit()

//        val adapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.city,
//            android.R.layout.simple_spinner_item
//        )
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spCity.adapter = adapter
//        spCity.onItemSelectedListener = this


        bottomNavigationMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemUpdate -> {
                    selectTab(MainScreenFragment())
                }
                else -> {}
            }
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.itemUpdate

    }

    private fun selectTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()

    }

//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val city: String = parent?.getItemAtPosition(position).toString()
//        spCityChoice = city
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//    }


}

