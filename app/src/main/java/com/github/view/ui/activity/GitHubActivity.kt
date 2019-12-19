package com.github.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.R
import com.github.databinding.GithubActivityBinding
import com.github.ui.fraggment.GitHubFragment
import android.view.MenuItem


class GitHubActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    var binding: GithubActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.github_activity)

        var fragment: Fragment? = null
        if (fragment == null)
            fragment = GitHubFragment()

        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commitAllowingStateLoss()
        setUpToolBar()
    }

    fun setUpToolBar() {
        binding?.toolbarTitle?.setText(getString(R.string.app_name))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.user_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.moreVertical ->
                // Do whatever you want to do on logout click.
                return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

}



