package com.example.listadapyter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapyter.databinding.ModelViewBinding

class MyModelVievHolder(val binding: ModelViewBinding):RecyclerView.ViewHolder(binding.root) {
//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null

    fun bindTo(model: MyModel){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       binding.name.text=model.name
        binding.id.text=model.id.toString()


    }
}