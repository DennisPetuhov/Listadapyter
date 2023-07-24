package com.example.listadapyter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapyter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val list = listOf<MyModel>(MyModel(1,"a"),MyModel(2,"b"),MyModel(3,"c"),MyModel(1,"d"))
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler()


    }
    fun recycler(){
        val adapter = MyModelRecyclerAdapter()
       binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        binding.recyclerView.adapter=adapter
        adapter.submitList(list)
    }
}