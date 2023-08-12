package com.example.listadapyter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.listadapyter.databinding.ModelViewBinding

class MyModelRecyclerAdapter :ListAdapter<MyModel,MyModelViewHolder>(MyModelDiffUtill()) {
    lateinit var binding: ModelViewBinding
    private var action:MySam?=null
    fun bind(action:MySam){
        this.action = action
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=ModelViewBinding.inflate(inflater,parent,false)
       return MyModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyModelViewHolder, position: Int) {
        val myModel =getItem(position)
       holder.bindTo(myModel)
        holder.binding.button.setOnClickListener {
            action?.delete(myModel)
        }

    }
}

sealed class MyAdapter{
    object Idle:MyAdapter()
    class Remove(val position: Int):MyAdapter()
    class Add(val myModel: MyModel):MyAdapter()
}