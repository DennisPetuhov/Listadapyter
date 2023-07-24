package com.example.listadapyter

import androidx.recyclerview.widget.DiffUtil

class MyModelDiffUtill:DiffUtil.ItemCallback<MyModel>() {
    override fun areItemsTheSame(oldItem: MyModel, newItem: MyModel): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: MyModel, newItem: MyModel): Boolean {
       return  oldItem==newItem
    }
}