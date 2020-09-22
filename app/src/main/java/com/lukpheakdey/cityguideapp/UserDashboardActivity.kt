package com.lukpheakdey.cityguideapp

import LoginSignup.StartUpScreenActivity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.lukpheakdey.cityguideapp.adapter.CategorieAdapter
import com.lukpheakdey.cityguideapp.adapter.CategoriesCardIconAdapter
import com.lukpheakdey.cityguideapp.adapter.FeatureAdapter
import com.lukpheakdey.cityguideapp.model.Category
import com.lukpheakdey.cityguideapp.model.Feature
import com.lukpheakdey.cityguideapp.viewmodel.CategoriesViewModel
import com.lukpheakdey.cityguideapp.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.activity_user_dashboard.*

class UserDashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var categorylist: ArrayList<Category>
    lateinit var featurelist: ArrayList<Feature>

    private lateinit var mCategoriesViewModel: CategoriesViewModel
    private lateinit var mPlaceViewModel: PlaceViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)



        var navigationView= this.findViewById<NavigationView>(R.id.navigation_view)
        var drawerLayout = this.findViewById<DrawerLayout>(R.id.drawer_layout)
        naviagtionDrawer()

        categorylist = ArrayList()
        featurelist = ArrayList()
        addFeatures()
        addCategory()

        categoriesRecycler()
        featuredRecycler()
        cardCategoryIconRecycler()


    }

    fun categoriesRecycler(){
        /*
        val list: ArrayList<String> = ArrayList()
        for (i in 0..5) {
            list.add("Title : " + (i +1))
        }
        val manage = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        categories_recycler.layoutManager = manage

        val adapter = CategorieAdapter(this, list)
        categories_recycler.adapter = adapter */

        /*  Previous work category recyclerview */
        /*
        categories_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        categories_recycler.adapter = CategorieAdapter(categorylist, this)
         */

        //RecyclerView
        val adapter = CategorieAdapter()
        categories_recycler.adapter = adapter
        categories_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // CategoryViewModel
        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mCategoriesViewModel.readAllDataCategory.observe(this, Observer { category ->
            adapter.setData(category)
        })

    }

    fun featuredRecycler() {
        /* Previous working one */
        /*
        featured_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        featured_recycler.adapter = FeatureAdapter(featurelist, this)*/

        //RecyclerView
        val adapter = FeatureAdapter()
        featured_recycler.adapter = adapter
        featured_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // PlaceViewModel
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)
        mPlaceViewModel.readAllDatPlaceWithFeature.observe(this, Observer { place ->
            adapter.setData(place)
        })

    }

    fun addFeatures() {
        featurelist.add(Feature("Mcdonald's", R.drawable.mcdonald_img))
        featurelist.add(Feature("Walmart", R.drawable.city_1))
        featurelist.add(Feature("Edenrobe", R.drawable.city_2))
    }

    fun addCategory() {
        categorylist.add(Category("Education", R.drawable.school_image))
        categorylist.add(Category("HOSPITAL", R.drawable.hospital_image))
        categorylist.add(Category("Restaurant", R.drawable.restaurant_image))
    }

    fun naviagtionDrawer() {
        navigation_view.bringToFront()
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.nav_home)
        drawer_layout.drawerElevation = 0.0F

        menu_icon.setOnClickListener {
            if(drawer_layout.isDrawerVisible(GravityCompat.START))
                drawer_layout.closeDrawer(GravityCompat.START)
            else drawer_layout.openDrawer(GravityCompat.START)
        }
        animateNavigationDrawer()
    }

    fun animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawer_layout.addDrawerListener(object : SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // Scale the View based on current slide offset
                val diffScaledOffset: Float = slideOffset * (1 - 0.7f)
                val offsetScale = 1 - diffScaledOffset
                content.setScaleX(offsetScale)
                content.setScaleY(offsetScale)

                // Translate the View, accounting for the scaled width
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff: Float = content.getWidth() * diffScaledOffset / 2
                val xTranslation = xOffset - xOffsetDiff
                content.setTranslationX(xTranslation)
            }
        })
    }

    // Selected Nav Menu
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_all_categories -> {
                Toast.makeText(this, "This all Category", Toast.LENGTH_SHORT).show()
                var i = Intent(applicationContext, AllCateogriesActivity::class.java)
                startActivity(i)
            }
            R.id.nav_all_places -> {
                Toast.makeText(this, "This all place", Toast.LENGTH_SHORT).show()
                var i = Intent(applicationContext, AllPlacesActivity::class.java)
                startActivity(i)
            }
            R.id.nav_restaurants ->{
                intentActionGo(1)
            }
            R.id.nav_car_rent ->{
                intentActionGo(2)
            }
            R.id.nav_hotel ->{
                intentActionGo(3)
            }
            R.id.nav_education ->{
                intentActionGo(4)
            }
            R.id.nav_shop ->{
                intentActionGo(5)
            }
        }
        return true
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerVisible(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else
            super.onBackPressed()
    }
    //Normal Functions
    fun callStartupScreens(view: View?) {
//        val sessionManager = SessionManager(this@UserDashboard, SessionManager.SESSION_USERSESSION)
//        if (sessionManager.checkLogin()) startActivity(
//            Intent(
//                applicationContext,
//                RetailerDashboard::class.java
//            )
//        ) else startActivity(
//            Intent(
//                applicationContext,
//                RetailerStartUpScreen::class.java
//            )
//        )
        var intent = Intent(this, StartUpScreenActivity::class.java)
        startActivity(intent)
    }


    fun cardCategoryIconRecycler(){
        //RecyclerView
        val adapter = CategoriesCardIconAdapter()
        card_cateogry_icon_viewed_recycler.adapter = adapter
        card_cateogry_icon_viewed_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // CategoryViewModel
        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mCategoriesViewModel.readAllDataCategory.observe(this, Observer { category ->
            adapter.setData(category)
        })
    }

    fun intentActionGo(categoryId: Int) {
        var intent = Intent(applicationContext, AllPlacesActivity::class.java)
        intent.putExtra("CALL_FROM_CATEGORY", "call_from_category")
        intent.putExtra("CATEOGRY_ID", categoryId)
        startActivity(intent)
    }

}