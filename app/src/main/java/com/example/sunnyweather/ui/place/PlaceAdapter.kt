package com.example.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.example.sunnyweather.logic.model.Place
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(private val fragment: Fragment, private val placeList:List<Place>):RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val tv_name:TextView = view.findViewById(R.id.tv_name)
        val tv_address:TextView = view.findViewById(R.id.tv_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.tv_name.text = place.name
        holder.tv_address.text = place.address
    }

    override fun getItemCount()=placeList.size
}