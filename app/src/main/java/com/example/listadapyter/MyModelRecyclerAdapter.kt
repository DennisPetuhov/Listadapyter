package com.example.listadapyter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.listadapyter.databinding.ModelViewBinding

class MyModelRecyclerAdapter :ListAdapter<MyModel,MyModelVievHolder>(MyModelDiffUtill()) {
    lateinit var binding: ModelViewBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelVievHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=ModelViewBinding.inflate(inflater,parent,false)
//        val view=inflater.inflate(R.layout.model_view,parent,false)
       return MyModelVievHolder(binding)
    }

    override fun onBindViewHolder(holder: MyModelVievHolder, position: Int) {
        val myModel =getItem(position)
       holder.bindTo(myModel)

    }
}