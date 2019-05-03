package com.namget.recyclerview.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_type1.*

class MyRecyclerViewAdapter(val list: MutableList<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TypeOneViewhodler(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer{


        fun bind(item: Product) {
            productName.text = item.name
//            itemView.productPrice.text = item.price.toString()
//            itemView.productImage.setImageResource(R.mipmap.ic_launcher)
//
//            itemView.productImage.setOnClickListener {
//                Toast.makeText(it.context, "image $adapterPosition", Toast.LENGTH_SHORT).show()
//            }
//            itemView.productName.setOnClickListener {
//                Toast.makeText(it.context, "name $adapterPosition", Toast.LENGTH_SHORT).show()
//            }
//            itemView.productPrice.setOnClickListener {
//                Toast.makeText(it.context, "price $adapterPosition", Toast.LENGTH_SHORT).show()
//            }

        }


    }

    class TypeTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_type1, parent, false)
        val viewhodler: TypeOneViewhodler = TypeOneViewhodler(view)
        Log.e("onCreateViewHolder", "viewType : " + viewType)
        return viewhodler
    }

    override fun getItemCount(): Int {
        Log.e("getItemCount", "list size :" + list.size)
        return list.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "position : " + position)
        (holder as TypeOneViewhodler).bind(list.get(position))

    }
}