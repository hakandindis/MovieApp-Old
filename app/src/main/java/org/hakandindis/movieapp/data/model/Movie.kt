package org.hakandindis.movieapp.data.model

import androidx.recyclerview.widget.DiffUtil
import org.hakandindis.movieapp.base.BaseModel

data class Movie(val id: Int, val name: String) : DiffUtil.ItemCallback<Movie>() {


    //    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//        return oldItem == newItem
//    }
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        TODO("Not yet implemented")
    }
}