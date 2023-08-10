package com.example.intent

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class customadapter(val activity:Activity, val list : ArrayList<OutData> ): ArrayAdapter<OutData>(activity, R.layout.custom_listview) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater
        val rowview = context.inflate(R.layout.custom_listview, parent, false)
        val img = rowview.findViewById<ImageView>(R.id.imgprofile)
        val name = rowview.findViewById<TextView>(R.id.txtname)
        img.setImageResource(list[position].img)
        name.text= list[position].name.toString()
        return rowview
    }
}