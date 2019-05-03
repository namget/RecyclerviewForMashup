package com.namget.recyclerview.listview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import kotlinx.android.synthetic.main.activity_listview.*

class ListViewActivity : AppCompatActivity() {

    val productList: ArrayList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        setListview()
    }

    fun setListview() {
        for (i in 1..10000) {
            productList.add(Product("선풍기${i}", 30000))
        }

        mListView.adapter = ListAdapter(productList)
    }

    class ListAdapter(val productList: ArrayList<Product>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            Log.e("getView", "position : " + position)

            val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_type1, parent, false)
            val image = view.findViewById<ImageView>(R.id.productImage)
            val name = view.findViewById<TextView>(R.id.productName)
            val price = view.findViewById<TextView>(R.id.productPrice)
            image.setImageResource(R.mipmap.ic_launcher)
            name.text = productList.get(position).name 
            price.text = "${productList.get(position).price} 원"

            return view
        }

        override fun getItem(position: Int): Any = position
        override fun getItemId(position: Int): Long = position as Long
        override fun getCount(): Int = productList.size ?: 0
    }


}