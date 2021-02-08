package com.test.presentation.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.inflate
import com.test.common.showFragment
import com.test.presentation.base.BaseFragment
import com.test.presentation.home.detail.DetailFragment
import com.test.test.R
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private val adapter =
        HomeAdapter {
            showFragment(R.id.container_main, DetailFragment.newInstance(it))
        }

    @Inject
    lateinit var vm: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = container?.inflate(R.layout.fragment_home)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.layoutManager = GridLayoutManager(context, 1, LinearLayoutManager.VERTICAL, false)
        rvList.adapter = adapter

        vm.load()
        vm.list.observe(viewLifecycleOwner, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }
}