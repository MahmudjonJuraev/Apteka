package com.example.apteki


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apteki.InfoFragments.ListFragment
import com.example.apteki.InfoFragments.MapFragment
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.fragment_list.*

@Suppress("DEPRECATION")
class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ListFragment() , " Ro'yxat ")
        adapter.addFragment(MapFragment() , " Xaritada ")
        ViewPager.adapter = adapter
        tabs.setupWithViewPager(ViewPager)
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment,title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }






}