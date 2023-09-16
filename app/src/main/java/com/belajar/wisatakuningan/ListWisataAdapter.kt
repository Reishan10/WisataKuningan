package com.belajar.wisatakuningan

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListWisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_wisata, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listWisata.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listWisata[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, listWisata[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailWisataActivity::class.java)
            intentDetail.putExtra(DetailWisataActivity.EXTRA_NAME, name)
            intentDetail.putExtra(DetailWisataActivity.EXTRA_DESC, description)
            intentDetail.putExtra(DetailWisataActivity.EXTRA_PHOTO, photo)
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}