package study.heltoe.mynewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import study.heltoe.mynewsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
//        mBinding.bottomNavigationView.setupWithNavController(mBinding.newsNavHostFragment.findNavController())
    }
}