package com.github.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.R
import com.github.databinding.GithubActivityBinding
import com.github.ui.fraggment.GitHubMainFragment

class GitHubAppMainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    var binding: GithubActivityBinding ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.github_activity)

        var fragment: Fragment? = null
        if (fragment == null)
            fragment = GitHubMainFragment()

        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commitAllowingStateLoss()
    }
    }



