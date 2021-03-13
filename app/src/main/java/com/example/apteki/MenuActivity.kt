package com.example.apteki

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.apteki.Fragments.About_app
import com.example.apteki.Fragments.Survey
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbarformenu.*

class MenuActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbarformenu)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbarformenu , R.string.open , R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(toggle)
        toolbarformenu.inflateMenu(R.menu.activity_main_drawer)
        setToolBar("Home")
        toggle.syncState()
        nav.setNavigationItemSelectedListener ( this )

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer_layout.closeDrawer(GravityCompat.START)


        when(item.itemId){
            R.id.info ->{
                setToolBar("First")
                changeFragment(About_app())
            }
            R.id.Sorovnoma ->{
                setToolBar("Second")
                changeFragment(Survey())
            }
        }
        return true
    }

    fun setToolBar(title:String){
        supportActionBar?.title= title
    }
    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frameLayout_contanier,frag).commit()
    }
}