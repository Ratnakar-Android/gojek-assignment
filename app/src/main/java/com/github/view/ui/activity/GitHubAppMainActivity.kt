package com.github.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.R
import com.github.databinding.GithubActivityBinding
import com.github.ui.fraggment.GitHubMainFragment

class GitHubAppMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : GithubActivityBinding = DataBindingUtil.setContentView(this, R.layout.github_activity)
        var fragment: Fragment? = null
        if (fragment == null)
            fragment = GitHubMainFragment()

    }

    private fun showFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {

        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }

            ft.replace(R.id.fragment_container, fragment, tag)
            ft.commitAllowingStateLoss()
        }
    }


}