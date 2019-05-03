package com.namget.recyclerview.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.namget.recyclerview.data.Product

class ListDiffCallback(val oldList: MutableList<Product>, val newList: MutableList<Product>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList.get(oldItemPosition) == newList.get(newItemPosition)

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList.get(oldItemPosition).equals(newList.get(newItemPosition))

}