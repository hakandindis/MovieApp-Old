package org.hakandindis.movieapp.base

abstract class BaseModel<T> {
    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean
    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean
}