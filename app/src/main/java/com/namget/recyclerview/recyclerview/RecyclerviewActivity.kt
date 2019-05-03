package com.namget.recyclerview.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlin.random.Random

class RecyclerviewActivity : AppCompatActivity() {
    val productList: MutableList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        setRecyclerView()
    }

    fun setRecyclerView() {
        for (i in 1..10000) {
            productList.add(Product("선풍기${i}", Random(System.currentTimeMillis() + i).nextInt(30000, 50000)))
        }

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerviewActivity)
            adapter = MyRecyclerViewAdapter(productList)
        }

    }


}