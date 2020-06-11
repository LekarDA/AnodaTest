package com.example.learning.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learning.business.PresenterImpl
import com.example.learning.R
import com.example.learning.data.Card
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val presenter = PresenterImpl()
    private lateinit var cards: List<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)

        rv_list.layoutManager = LinearLayoutManager(this)
        val adapter = CardsAdapter()
        rv_list.adapter = adapter

        cards = presenter.getListOfCards(this)
        adapter.setData(cards)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.page_1 -> Toast.makeText(this,
                R.string.menu_home, Toast.LENGTH_SHORT).show()
            R.id.page_2 -> Toast.makeText(this,
                R.string.menu_search, Toast.LENGTH_SHORT).show()
            R.id.page_3 -> Toast.makeText(this,
                R.string.menu_add, Toast.LENGTH_SHORT).show()
            R.id.page_4 -> Toast.makeText(this,
                R.string.menu_liked, Toast.LENGTH_SHORT).show()
            R.id.page_5 -> Toast.makeText(this,
                R.string.menu_account, Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
