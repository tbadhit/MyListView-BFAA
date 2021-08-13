package com.tbadhit.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

// Jika ingin membuat adapter yang lebih kompleks gunakan "BaseAdapter"

// Open activity_main.xml (update code) (1)
// Open MainActivity (add code) (1)
// Create new kotlin class, name it "Hero"
// Add asset image
// Create new resource file "item_hero.xml"
// Add code in "item_hero.xml" (1)
// add text to "strings.xml"

// (Try custom adapter) :
// Create new kotlin class, name it "HeroAdapter"
// Add code in "HeroAdapter" (1)
// Add code in "MainActivity" (2) (3) (4) (5)

class MainActivity : AppCompatActivity() {

    // (1)
    // (Create list with ArrayAdapter)
    // private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Pattimura", "R A Kartini", "Sukarno")

    // (2)
    // (Create list with BaseAdapter)
    private lateinit var adapter: HeroAdapter

    // (3)
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray

    // (4)
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // (1)
        val listView: ListView = findViewById(R.id.lv_list)

        // (1)
        // (Create list with ArrayAdapter)
        // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName)

        // (2)
        // (Create list with BaseAdapter)
        adapter = HeroAdapter(this)
        listView.adapter = adapter
        //---

        // (3)
        prepare()

        // (4)
        addItem()

        // (5)
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    // (3)
    // prepare digunakan untuk inisiasi setiap data
    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    // (4)
    // addItem() digunakan untuk memasukan data data ke arraylist supaya bisa diproses oleh adapter
    private fun addItem() {
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }

}