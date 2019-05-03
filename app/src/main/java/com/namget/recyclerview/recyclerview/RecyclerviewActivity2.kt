package com.namget.recyclerview.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.namget.recyclerview.R
import com.namget.recyclerview.data.Product
import com.namget.recyclerview.data.ProductSpec
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlin.random.Random

class RecyclerviewActivity2 : AppCompatActivity() {

    val specProductList: MutableList<Any> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        setSpecRecyclerView()
    }

    fun setSpecRecyclerView() {
        for (i in 1..10000) {
            specProductList.add(Product("선풍기${i}", Random(System.currentTimeMillis() + i).nextInt(30000, 50000)))
            specProductList.add(ProductSpec("8중날을 갖고있으며 오지게 좋음 굿굿"))
        }

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerviewActivity2)
            adapter = SpecRecyclerViewAdapter(specProductList)
        }
    }

}