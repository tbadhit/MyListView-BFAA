package com.tbadhit.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    // (1)
    internal var heroes = arrayListOf<Hero>()

    // (1)
    // untuk mengetahui berapa banyak item yang akan ditampilkan
    override fun getCount(): Int {
        return heroes.size
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Akan terjadi proses pemanggilan textview dan settext
    // (getView()) = untuk memanggil layout item xml yang sudah dibuat dan melakukan...
    // proses manipulasi setiap komponennya seperti textview dan imageview melalui kelas ViewHolder
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // (1)
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        // (1)
        val viewHolder = ViewHolder(itemView as View)

        // (1)
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView

    }
    //-----

    // (1)
    private inner class ViewHolder(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }
}