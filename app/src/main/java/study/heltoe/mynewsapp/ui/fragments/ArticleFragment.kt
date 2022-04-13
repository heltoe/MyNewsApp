package study.heltoe.mynewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import study.heltoe.mynewsapp.databinding.FragmentArticleBinding
import study.heltoe.mynewsapp.ui.MainActivity
import study.heltoe.mynewsapp.ui.NewsViewModel

class ArticleFragment: Fragment() {
    private var _binding: FragmentArticleBinding? = null
    private val mBinding get() = _binding!!
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
        var article = args.article
        mBinding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url ?: "")
        }

        mBinding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(mBinding.fragmentArticleRoot, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}