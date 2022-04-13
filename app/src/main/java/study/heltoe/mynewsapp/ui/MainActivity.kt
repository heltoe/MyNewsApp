package study.heltoe.mynewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import study.heltoe.mynewsapp.R
import study.heltoe.mynewsapp.databinding.ActivityMainBinding
import study.heltoe.mynewsapp.ui.db.ArticleDataBase
import study.heltoe.mynewsapp.ui.repository.NewsRepository

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        init()
    }
    private fun init() {
        val newsRepository = NewsRepository(ArticleDataBase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        //
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        mBinding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}