package com.example.listadapyter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapyter.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private val adapter = MyModelRecyclerAdapter()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observe()
        observeAdapterState()
        viewModel.produceList()



    }

    private fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                        recycler(it)
//                        adapter.notifyItemRemoved(it.)
                    }

            }
        }
    }
    private fun recycler(list: List<MyModel>) {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(list)
        click()
    }


    private fun observeAdapterState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.myAdapter.collect {
                    when (it) {
                        is MyAdapter.Idle -> {}
                        is MyAdapter.Remove -> {
                            adapter.notifyItemRemoved(it.position)
                        }

                        is MyAdapter.Add -> {

                            // adapter.notifyItemInserted(viewModel.userList.value.lastIndex)
                        }
                    }
                }
            }
        }
    }




    private fun click() {
        adapter.bind {
            viewModel.deleteItem(it)


        }
    }
}