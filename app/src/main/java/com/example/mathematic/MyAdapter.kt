package com.example.mathematic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mathematic.data.User
import kotlinx.android.synthetic.main.activity_result.view.*

 class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(user : User) {
            itemView.tvResult.text = " ${user.name}  ${user.score} "
        }
    }

    var models: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view =  LayoutInflater.from(parent.context).inflate(R.layout.activity_result,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
 }