package com.example.listadapyter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val list = mutableListOf(MyModel(1, "a"), MyModel(2, "b"), MyModel(3, "c"), MyModel(4, "d"))


    val state: StateFlow<List<MyModel>> get() = _state
    private val _state = MutableStateFlow<MutableList<MyModel>>(mutableListOf())


    private val _myAdapter: MutableStateFlow<MyAdapter> = MutableStateFlow(MyAdapter.Idle)
    val myAdapter: StateFlow<MyAdapter> = _myAdapter


    private fun emitList(): Flow<MutableList<MyModel>> {

        return flow {
            emit(list)
        }
    }


    fun produceList() {
        viewModelScope.launch {
            emitList().collect {
                _state.value = it
            }

        }
    }

    fun deleteItem(myModel: MyModel) {
        viewModelScope.launch {
            val removedUserListIndex = _state.value.indexOf(myModel)
            _state.value.removeAt(removedUserListIndex)
            _myAdapter.value = MyAdapter.Remove(removedUserListIndex)



        }

    }


}
