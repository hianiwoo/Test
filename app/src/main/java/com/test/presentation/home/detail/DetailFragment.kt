package com.test.presentation.home.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.common.inflate
import com.test.domain.models.Anime
import com.test.presentation.base.BaseFragment
import com.test.test.R
import com.test.test.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var vm: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = container!!.inflate(R.layout.fragment_detail)
        binding = FragmentDetailBinding.bind(v)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        val item = requireArguments().getParcelable<Anime>("item") ?: return

        binding.item = item
    }

    companion object {
        fun newInstance(anime: Anime): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("item", anime)
            fragment.arguments = bundle
            return fragment
        }
    }
}