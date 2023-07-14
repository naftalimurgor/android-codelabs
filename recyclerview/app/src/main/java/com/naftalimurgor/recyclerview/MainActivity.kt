package com.naftalimurgor.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.naftalimurgor.recyclerview.adapter.ItemAdapter
import com.naftalimurgor.recyclerview.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        // Initialize data
        val myDataSet = DataSource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataSet)
        // we use this to improve performance if you know that content do not change the size of the layout of the RecyclerView
        recyclerView.setHasFixedSize(true) // since we know the size of the dataset
    }
}