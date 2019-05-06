package com.namget.recyclerview.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import com.namget.recyclerview.data.ProductSpec

class SpecRecyclerViewAdapter(val list: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val PRODUCTTYPE = 1
    val SPECTYPE = 2


    class TypeOneViewhodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: ImageView
        lateinit var name: TextView
        lateinit var price: TextView

        init {
            image = itemView.findViewById(R.id.productImage)
            name = itemView.findViewById(R.id.productName)
            price = itemView.findViewById(R.id.productPrice)
        }


        init {

            image.setOnClickListener {
                Toast.makeText(it.context, "image $adapterPosition", Toast.LENGTH_SHORT).show()
            }
            name.setOnClickListener {
                Toast.makeText(it.context, "name $adapterPosition", Toast.LENGTH_SHORT).show()
            }
            price.setOnClickListener {
                Toast.makeText(it.context, "price $adapterPosition", Toast.LENGTH_SHORT).show()
            }

        }

    }

    class TypeTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var spec: TextView

        init {
            spec = itemView.findViewById(R.id.specDescription)
        }

        init {
            itemView.setOnClickListener {
                Snackbar.make(itemView.rootView, spec.text.toString(), Snackbar.LENGTH_SHORT).show()
            }
            spec.setOnClickListener {
                Snackbar.make(itemView.rootView, "하나 살래?", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.e("onCreateViewHolder", "viewType : " + viewType)

        if (viewType == PRODUCTTYPE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_type1, parent, false)
            val viewhodler: TypeOneViewhodler = TypeOneViewhodler(view)
            return viewhodler
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_type2, parent, false)
            val viewhodler: TypeTwoViewHolder = TypeTwoViewHolder(view)
            return viewhodler
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

        if (getItemViewType(position) == PRODUCTTYPE) {
            (holder as TypeOneViewhodler).apply {
                this.image.setImageResource(R.mipmap.ic_launcher)
                this.name.text = (list.get(position) as Product).name
                this.price.text = "${(list.get(position) as Product).price} 원"
            }
        } else {
            (holder as TypeTwoViewHolder).apply {
                this.spec.text = (list.get(position) as ProductSpec).spec
            }
        }

    }
}