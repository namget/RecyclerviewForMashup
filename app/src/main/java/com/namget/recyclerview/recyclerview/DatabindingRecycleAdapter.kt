package com.namget.recyclerview.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import com.namget.recyclerview.data.ProductSpec
import com.namget.recyclerview.databinding.ItemListTypeDatabinding1Binding
import com.namget.recyclerview.databinding.ItemListTypeDatabinding2Binding

class DatabindingRecycleAdapter(val list: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val PRODUCTTYPE = 1
    val SPECTYPE = 2


    class TypeOneViewhodler(val binding: ItemListTypeDatabinding1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.product = item
        }
    }

    class TypeTwoViewHolder(val binding: ItemListTypeDatabinding2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductSpec) {
            binding.productSpec = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.e("onCreateViewHolder", "viewType : " + viewType)
        when (viewType) {
            PRODUCTTYPE -> {
                val binding: ItemListTypeDatabinding1Binding =
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_list_type_databinding1,
                        parent,
                        false
                    )
                return TypeOneViewhodler(binding)
            }
            SPECTYPE -> {
                val binding: ItemListTypeDatabinding2Binding =
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_list_type_databinding2,
                        parent,
                        false
                    )
                return TypeTwoViewHolder(binding)
            }
            else -> throw Exception()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list.get(position) is Product) {
            return PRODUCTTYPE
        } else if (list.get(position) is ProductSpec) {
            return SPECTYPE
        } else {
            return 0
        }
    }

    override fun getItemCount(): Int {
        Log.e("getItemCount", "list size :" + list.size)
        return list.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "position : " + position)
        when (getItemViewType(position)) {
            PRODUCTTYPE -> {
                (holder as TypeOneViewhodler).bind(list[position] as Product)
            }
            SPECTYPE -> {
                (holder as TypeTwoViewHolder).bind(list[position] as ProductSpec)
            }
        }

    }
}