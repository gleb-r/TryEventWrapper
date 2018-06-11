package com.example.radgl.tryeventwrapper.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.radgl.tryeventwrapper.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnTest.setOnClickListener { viewModel.userClicksButton("testItem") }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel.navigateToDetails.observe(this, Observer {
//            it?.getContentIfNotHandled()?.let {
//                navigate(it)
//            }
//        })

        viewModel.navigateToDetails.observe(this, EventObserver { navigate(it) })

    }

    private fun navigate(itemId: String) {
        Log.i("TAG", "navigate with item = $itemId")
    }


}
