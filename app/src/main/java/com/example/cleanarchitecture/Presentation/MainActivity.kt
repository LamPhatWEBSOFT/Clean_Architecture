package com.example.cleanarchitecture.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.cleanarchitecture.Presentation.library.LibraryFragment
import com.google.android.material.navigation.NavigationView
import com.example.clean_architecture.domain.Document
import com.example.cleanarchitecture.Presentation.reader.ReaderFragment
import com.example.cleanarchitecture.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    MainActivityDelegate {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_library -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, LibraryFragment.newInstance())
                .commit()
            R.id.nav_reader -> openDocument(
                Document.EMPTY)
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun openDocument(document: Document) {
        nav_view.menu.findItem(R.id.nav_reader).isChecked = true
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, ReaderFragment.newInstance(document))
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toggle = ActionBarDrawerToggle(this, drawer_layout,
            toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        nav_view.menu.findItem(R.id.nav_library).isChecked = true
        nav_view.menu.performIdentifierAction(R.id.nav_library, 0)
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
