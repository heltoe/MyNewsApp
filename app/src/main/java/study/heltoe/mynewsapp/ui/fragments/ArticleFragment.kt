package study.heltoe.mynewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import study.heltoe.mynewsapp.R
import study.heltoe.mynewsapp.databinding.FragmentArticleBinding
import study.heltoe.mynewsapp.ui.MainActivity
import study.heltoe.mynewsapp.ui.NewsViewModel

class ArticleFragment: Fragment() {
    private var _binding: FragmentArticleBinding? = null
    val mBinding get() = _binding!!
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        viewModel = (activity as MainActivity).viewModel
    }
}