package com.namget.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.namget.recyclerview.listview.ListViewActivity
import com.namget.recyclerview.recyclerview.RecyclerviewActivity
import com.namget.recyclerview.recyclerview.RecyclerviewActivity2
import com.namget.recyclerview.recyclerview.RecyclerviewActivity3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myListview.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListViewActivity::class.java))
        }

        myRecyclerView.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerviewActivity::class.java))
        }

        myRecyclerView2.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerviewActivity2::class.java))
        }

        myRecyclerView3.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerviewActivity3::class.java))
        }

    }
}
