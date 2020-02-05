package com.ternaryop.coilflashing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ImagePickerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    var coilCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = listOf(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10
        )

        viewManager = GridLayoutManager(this, 3)
        viewAdapter = ImagePickerAdapter(res)

        val coil = findViewById<Button>(R.id.btn_coil)
        coil.setOnClickListener {
            viewAdapter.notifyDataSetChanged()
            coil.text = "Refresh $coilCount"
            coilCount +=1
        }
        recyclerView = findViewById<RecyclerView>(R.id.gridview).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }


    }
}
