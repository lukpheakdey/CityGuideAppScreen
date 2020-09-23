package com.lukpheakdey.cityguideapp.script

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.model.Categories
import com.lukpheakdey.cityguideapp.model.Place
import com.lukpheakdey.cityguideapp.viewmodel.CategoriesViewModel
import com.lukpheakdey.cityguideapp.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.activity_script_data.*

class ScriptDataActivity : AppCompatActivity() {

    private lateinit var mCategoriesViewModel: CategoriesViewModel

    private lateinit var mPlaceViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script_data)

        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        btn_create_category.setOnClickListener {
            runAddCategories()
        }

        btn_create_category1.setOnClickListener {
            runAddCategories1()
        }

        btn_create_category2.setOnClickListener {
            runAddCategories2()
        }

        btn_create_category3.setOnClickListener {
            runAddCategories3()
        }

        btn_create_category4.setOnClickListener {
            runAddCategories4()
        }

        btn_create_place.setOnClickListener {
            runAddPlaces()
        }

        back_pressed.setOnClickListener {
            super.onBackPressed()
        }
    }

    //simple to create category
    fun runAddCategories() {
        val name = "Reaturant"
        val desc = "Restaurant place have to go for eatting"
        val image = "restaurant_image"
        val color = "#d4cbe5"
        val category = Categories(0, name, desc, image, color)
        mCategoriesViewModel.addCategory(category)
        Toast.makeText(this, "Create category 1 ", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories1() {
        val name1 = "Car Rents"
        val desc1 = "Car Rents place to visit in this city"
        val image1 = "transport_image"
        val color1 = "#947AE8"
        val category1 = Categories(0, name1, desc1, image1, color1)
        mCategoriesViewModel.addCategory(category1)
        Toast.makeText(this, "Create category 2 ", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories2() {
        val name2 = "Hotels"
        val desc2 = "The best sleeping place"
        val image2 = "vlog"
        val color2 = "#7adccf"
        val category2 = Categories(0, name2, desc2, image2, color2)
        mCategoriesViewModel.addCategory(category2)
        Toast.makeText(this, "Create category 3", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories3() {
        val name3 = "Education"
        val desc3 = "School and unviersity"
        val image3 = "school_image"
        val color3 = "#f7c59f"
        val category3 = Categories(0, name3, desc3, image3, color3)
        mCategoriesViewModel.addCategory(category3)
        Toast.makeText(this, "Create category 4", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories4() {
        val name4 = "Shops"
        val desc4 = "There are alot mall around here"
        val image4 = "shopping_image"
        val color4 = "#b8d7f5"
        val category4 = Categories(0, name4, desc4, image4, color4)
        mCategoriesViewModel.addCategory(category4)
        Toast.makeText(this, "Create category 5", Toast.LENGTH_SHORT).show()
    }

    //Simple input Place to table
    fun runAddPlaces() {
        val place_name = "McDonald's"
        val place_desc = "Classic, long-running fast-food chain known for its burgers, fries & shakes."
        val phone = "(703) 680-2994"
        val address = "4245 Dale Blvd, Dale City, VA 22193"
        val star_point = "4"
        val feature = 1
        val open_time = "24Hour"
        val close_time = "No"
        val day_open = "7day"
        val day_close = "No"
        val image_url = "https://i.ibb.co/HGmnmL1/mcdonald.jpg"
        val map_url = "https://www.google.com/maps/dir/38.6393081,-77.320955/McDonald+near+me/@38.6401115,-77.3500566,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x89b657cc249ed649:0x23210dc580bc83e1!2m2!1d-77.3375056!2d38.6445961"
        val website = "https://www.mcdonalds.com/"
        val review = "Nice place have lunch with family"
        val category_id = 1
        val place = Place(
            0,
            place_name,
            place_desc,
            phone,
            address,
            star_point,
            feature,
            open_time,
            close_time,
            day_open,
            day_close,
            image_url,
            map_url,
            website,
            review,
            category_id
        )

        val place_name1 = "Steak House"
        val place_desc1 = "Get Outback Steakhouse for Delivery or Pickup"
        val phone1 = "(703) 490-5336"
        val address1 = "14580 Potomac Mills Rd, Woodbridge, VA 22192"
        val star_point1 = "4.5"
        val feature1 = 1
        val open_time1 = "24Hour"
        val close_time1 = "No"
        val day_open1 = "7day"
        val day_close1 = "No"
        val image_url1 = "https://i.ibb.co/r7CYDc2/steak-house.jpg"
        val map_url1 = "https://www.google.com/maps/dir/38.6393081,-77.320955/steakhouse+near+me/@38.6330782,-77.3280787,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x89b6561ad2c74503:0x9d000bae9df4046!2m2!1d-77.2979998!2d38.6357587"
        val website1 = "https://www.outback.com/"
        val review1 = "The good steak for us"
        val category_id1 = 1
        val place1 = Place(
            0,
            place_name1,
            place_desc1,
            phone1,
            address1,
            star_point1,
            feature1,
            open_time1,
            close_time1,
            day_open1,
            day_close1,
            image_url1,
            map_url1,
            website1,
            review1,
            category_id1
        )

        val place_name3 = "Sushi Bae"
        val place_desc3 = "Sushi Bae - Woodbridge, VA - Pickup with Grubhub"
        val phone3 = "(703) 878-8878"
        val address3 = "12492 Dillingham Square, Woodbridge, VA 22192"
        val star_point3 = "4.2"
        val feature3 = 1
        val open_time3 = "12PM"
        val close_time3 = "10PM"
        val day_open3 = "7day"
        val day_close3 = "No"
        val image_url3 = "https://i.ibb.co/1QKBS5j/sushi.jpg"
        val map_url3 = "https://www.google.com/maps/dir//sushi+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b656ef1169f45d:0xaa143da775b6957f?sa=X&ved=2ahUKEwiNrqikw-7rAhVCmXIEHWhnANAQ9RcwAHoECA0QBQ"
        val website3 = "http://www.sushibae.com/menu"
        val review3 = "Best japanese food "
        val category_id3 = 1
        val place3 = Place(
            0,
            place_name3,
            place_desc3,
            phone3,
            address3,
            star_point3,
            feature3,
            open_time3,
            close_time3,
            day_open3,
            day_close3,
            image_url3,
            map_url3,
            website3,
            review3,
            category_id3
        )

        val place_name4 = "Enterprise Rent-A-Car"
        val place_desc4 = "Good service"
        val phone4 = "(703) 580-5852"
        val address4 = "2850 Dale Blvd, Dale City, VA 22193"
        val star_point4 = "3.5"
        val feature4 = 0
        val open_time4 = "7AM"
        val close_time4 = "5PM"
        val day_open4 = "7day"
        val day_close4 = "No"
        val image_url4 = "https://i.ibb.co/PmxQJG1/enterprise-car-rental.png"
        val map_url4 = "https://www.google.com/maps/dir//car+rent+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b6561d37fab6a7:0x649bc5df855839d1?sa=X&ved=2ahUKEwjmvJfow-7rAhX-oXIEHbD9BV0Q9RcwAHoECAkQBA"
        val website4 = "https://www.enterprise.com/"
        val review4 = "Good for rental car"
        val category_id4 = 2
        val place4 = Place(
            0,
            place_name4,
            place_desc4,
            phone4,
            address4,
            star_point4,
            feature4,
            open_time4,
            close_time4,
            day_open4,
            day_close4,
            image_url4,
            map_url4,
            website4,
            review4,
            category_id4
        )

        val place_name5 = "Next Car Rental Leasing Sales"
        val place_desc5 = "Car rental agency in Newington, Virginia"
        val phone5 = "(734) 845-4657"
        val address5 = "7200 Fullerton Rd # H, Springfield, VA 22150"
        val star_point5 = "4.1"
        val feature5 = 1
        val open_time5 = "7AM"
        val close_time5 = "5PM"
        val day_open5 = "7day"
        val day_close5 = "No"
        val image_url5 = "https://i.ibb.co/FnqG3jF/Next-car-rental.png"
        val map_url5 = "https://www.google.com/maps/dir//car+rent+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b6561d37fab6a7:0x649bc5df855839d1?sa=X&ved=2ahUKEwje3tTzxO7rAhUHg3IEHTv5BwYQ9RcwAHoECAQQBA"
        val website5 = "https://nextcarrental.com/"
        val review5 = "Good for rental car"
        val category_id5 = 2
        val place5 = Place(
            0,
            place_name5,
            place_desc5,
            phone5,
            address5,
            star_point5,
            feature5,
            open_time5,
            close_time5,
            day_open5,
            day_close5,
            image_url5,
            map_url5,
            website5,
            review5,
            category_id5
        )

        val place_name6 = "Avis Car Rental"
        val place_desc6 = "Car rental agency in Springfield, Virginia"
        val phone6 = "(703) 924-2340"
        val address6 = "Comfort Inn, 6560 Loisdale Ct, Springfield, VA 22150"
        val star_point6 = "4.5"
        val feature6 = 1
        val open_time6 = "7AM"
        val close_time6 = "5PM"
        val day_open6 = "7day"
        val day_close6 = "No"
        val image_url6 = "https://i.ibb.co/LxyRsMT/rental-car.jpg"
        val map_url6 = "https://www.google.com/maps/dir//car+rent+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b7ad58e5d1aff5:0x400cd3444ad381b2?sa=X&ved=2ahUKEwjW2paXxe7rAhVAlnIEHSx6Dc8Q9RcwAHoECAkQBA"
        val website6 = "https://www.avis.com/"
        val review6 = "Good for rental car"
        val category_id6 = 2
        val place6 = Place(
            0,
            place_name6,
            place_desc6,
            phone6,
            address6,
            star_point6,
            feature6,
            open_time6,
            close_time6,
            day_open6,
            day_close6,
            image_url6,
            map_url6,
            website6,
            review6,
            category_id6
        )

        val place_name7 = "Best Western Potomac Mills"
        val place_desc7 = "Modest hotel with complimentary breakfast & parking, plus an outdoor pool & a fitness center."
        val phone7 = "(703) 494-4433"
        val address7 = "14619 Potomac Mills Rd, Woodbridge, VA 22192"
        val star_point7 = "3.9"
        val feature7 = 1
        val open_time7 = "24Hour"
        val close_time7 = "No"
        val day_open7 = "7day"
        val day_close7 = "No"
        val image_url7 = "https://i.ibb.co/JR6Td9x/best-western-hotel.jpg"
        val map_url7 = "https://www.google.com/maps?gl=US&hl=en&um=1&ie=UTF-8&fb=1&sa=X&geocode=KTOGji8FVraJMRwNJJVINOjV&daddr=Best+Western+Potomac+Mills,+14619+Potomac+Mills+Rd,+Woodbridge,+VA+22192"
        val website7 = "https://www.bestwestern.com/"
        val review7 = "Part of the Potomac Mills shopping mall, this unpretentious hotel off I-95 is 5 miles from Occoquan Bay National Wildlife Refuge and 9 miles from the National Museum of the Marine Corps."
        val category_id7 = 3
        val place7 = Place(
            0,
            place_name7,
            place_desc7,
            phone7,
            address7,
            star_point7,
            feature7,
            open_time7,
            close_time7,
            day_open7,
            day_close7,
            image_url7,
            map_url7,
            website7,
            review7,
            category_id7
        )

        val place_name9 = "Hilton Garden Inn"
        val place_desc9 = "Unassuming hotel with a casual bar & grill, plus a terrace, an indoor pool & free Wi-Fi"
        val phone9 = "(703) 590-2500"
        val address9 = "2500 Neabsco Common Pl, Woodbridge, VA 22191"
        val star_point9 = "3.0"
        val feature9 = 1
        val open_time9 = "24Hour"
        val close_time9 = "No"
        val day_open9 = "7day"
        val day_close9 = "No"
        val image_url9 = "https://i.ibb.co/9t1MLP0/hilton-garden.jpg"
        val map_url9 = "https://www.google.com/maps?gl=US&hl=en&um=1&ie=UTF-8&fb=1&sa=X&geocode=KS3Ya9m0-LaJMX_vnSe1FotW&daddr=Hilton+Garden+Inn+Woodbridge,+VA,+2500+Neabsco+Common+Pl,+Woodbridge,+VA+22191"
        val website9 = "https://www.hilton.com/en/"
        val review9 = "In a commercial area off Interstate 95, this unassuming hotel is 5 miles from Leesylvania State Park and 2 miles from Potomac Mills Mal"
        val category_id9 = 3
        val place9 = Place(
            0,
            place_name9,
            place_desc9,
            phone9,
            address9,
            star_point9,
            feature9,
            open_time9,
            close_time9,
            day_open9,
            day_close9,
            image_url9,
            map_url9,
            website9,
            review9,
            category_id9
        )

        val place_name10 = "Potomac Mills"
        val place_desc10 = "Potomac Mills is a shopping mall located in Woodbridge, Virginia in the Washington, D.C., metropolitan area. Located near Interstate 95 between Smoketown Road, Telegraph Road and the Prince William Parkway"
        val phone10 = "(703) 496-9330"
        val address10 = "2700 Potomac Mills Cir, Woodbridge, VA 22192\n"
        val star_point10 = "4.6"
        val feature10 = 0
        val open_time10 = "7AM"
        val close_time10 = "10PM"
        val day_open10 = "7day"
        val day_close10 = "No"
        val image_url10 = "https://i.ibb.co/Hzd3NYs/Potomac-Mills.jpg"
        val map_url10 = "https://www.google.com/maps/dir//mall+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b6560c434b0b95:0xf02d45fbb1ae48bc?sa=X&ved=2ahUKEwjqg_jEx-7rAhUVmXIEHUGLCiIQ9RcwAHoECBQQBQ"
        val website10 = "https://www.simon.com/mall/potomac-mills"
        val review10 = "Shopping mall"
        val category_id10 = 5
        val place10 = Place(
            0,
            place_name10,
            place_desc10,
            phone10,
            address10,
            star_point10,
            feature10,
            open_time10,
            close_time10,
            day_open10,
            day_close10,
            image_url10,
            map_url10,
            website10,
            review10,
            category_id10
        )

        val place_name11 = "Nike Store"
        val place_desc11 = "Nike Clearance store"
        val phone11 = "(703) 497-4513"
        val address11 = "2700 Potomac Mills Cir, Woodbridge, VA 22192"
        val star_point11 = "4.0"
        val feature11 = 1
        val open_time11 = "7AM"
        val close_time11 = "10PM"
        val day_open11 = "7day"
        val day_close11 = "No"
        val image_url11 = "https://i.ibb.co/7r7vxbz/nike-store.jpg"
        val map_url11 = "https://www.google.com/maps/dir//mall+near+me/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x89b657f4a7159fdf:0x268d8b9e29156baf?sa=X&ved=2ahUKEwj2l6yYyO7rAhUGl3IEHa6AD7EQ9RcwAHoECAcQAw"
        val website11 = "https://www.nike.com/"
        val review11 = "Nike shoe store"
        val category_id11 = 5
        val place11 = Place(
            0,
            place_name11,
            place_desc11,
            phone11,
            address11,
            star_point11,
            feature11,
            open_time11,
            close_time11,
            day_open11,
            day_close11,
            image_url11,
            map_url11,
            website11,
            review11,
            category_id11
        )

        val place_name12 = "AMC Potomac Mills 18"
        val place_desc12 = "As a leader in the movie exhibition industry."
        val phone12 = "(703)792-8420"
        val address12 = "2700 Potomac Mills Circle Suite, Woodbridge, VA 22192"
        val star_point12 = "4.1"
        val feature12 = 0
        val open_time12 = "7AM"
        val close_time12 = "10PM"
        val day_open12 = "7day"
        val day_close12 = "No"
        val image_url12 = "https://i.ibb.co/FwzXJsh/AMC0.jpg"
        val map_url12 = "https://www.google.com/maps?q=AMC+Potomac+Mills+18&um=1&ie=UTF-8&sa=X&ved=2ahUKEwipitavye7rAhXSoHIEHbWADRQQ_AUoAXoECCIQAw"
        val website12 = "https://www.amctheatres.com/"
        val review12 = "Everyone wearing masks and socially distancing."
        val category_id12 = 5
        val place12 = Place(
            0,
            place_name12,
            place_desc12,
            phone12,
            address12,
            star_point12,
            feature12,
            open_time12,
            close_time12,
            day_open12,
            day_close12,
            image_url12,
            map_url12,
            website12,
            review12,
            category_id12
        )

        val place_name13 = "Mc Donalds"
        val place_desc13 = "Classic, long-running fast-food chain known for its burgers, fries & shakes"
        val phone13 = "(703) 243-5694"
        val address13 = "40 N Glebe Rd, Arlington, VA 22203"
        val star_point13 = "4.1"
        val feature13 = 0
        val open_time13 = "7AM"
        val close_time13 = "10PM"
        val day_open13 = "7day"
        val day_close13 = "No"
        val image_url13 = "https://i.ibb.co/bHxSLzG/Halifax-Nova-Scotia-Canada-May-27-2012-A-new-style-redesigned-Mc-Doanld-s-MC-Cafe-location-at-dusk-w.jpg"
        val map_url13 = "https://www.google.com/maps/place/McDonald's/@38.2540722,117.7288648,4z/data=!4m19!1m13!4m12!1m4!2m2!1d-122.0307375!2d37.5343397!4e1!1m6!1m2!1s0x89b7b6a06df687d3:0x386714705e85b9c6!2smcdonald'sarlington+va!2m2!1d-77.1017296!2d38.8709948!3m4!1s0x89b7b6a06df687d3:0x386714705e85b9c6!8m2!3d38.8709948!4d-77.1017296"
        val website13 = "https://www.mcdonalds.com"
        val review13 = "Everyone wearing masks and socially distancing."
        val category_id13 = 1
        val place13 = Place(
            0,
            place_name13,
            place_desc13,
            phone13,
            address13,
            star_point13,
            feature13,
            open_time13,
            close_time13,
            day_open13,
            day_close13,
            image_url13,
            map_url13,
            website13,
            review13,
            category_id13
        )

        val place_name14 = "StarBucks"
        val place_desc14 = "Seattle-based coffeehouse chain known for its signature roasts, light bites and WiFi availability."
        val phone14 = "(703) 243-5694"
        val address14 = "460 N Mathilda Ave, Sunnyvale, CA 94085"
        val star_point14 = "4.1"
        val feature14 = 0
        val open_time14 = "7AM"
        val close_time14 = "10PM"
        val day_open14 = "7day"
        val day_close14 = "No"
        val image_url14 = "https://i.ibb.co/b7Dmczk/247-Wall-St-com-247-WS-466075-starbucks-pune.jpg"
        val map_url14 = "https://www.google.com/maps/place/Starbucks/@37.388348,-122.032526,17z/data=!3m1!4b1!4m12!1m6!3m5!1s0x808fb6517d9f935d:0xa63ab8e697a4830c!2sStarbucks!8m2!3d37.388348!4d-122.030332!3m4!1s0x808fb6517d9f935d:0xa63ab8e697a4830c!8m2!3d37.388348!4d-122.030332"
        val website14 = "http://www.starbucks.com/store/16802/"
        val review14 = "Everyone wearing masks and socially distancing."
        val category_id14 = 1
        val place14 = Place(
            0,
            place_name14,
            place_desc14,
            phone14,
            address14,
            star_point14,
            feature14,
            open_time14,
            close_time14,
            day_open14,
            day_close14,
            image_url14,
            map_url1,
            website14,
            review14,
            category_id14
        )

        val place_name15 = "Taco Bell"
        val place_desc15 = "Fast-food chain serving Mexican-inspired fare such as tacos, quesadillas & nachos."
        val phone15 = "6413576050"
        val address15 = "10 Plaza Dr, Clear Lake, IA 50428"
        val star_point15 = "4.1"
        val feature15 = 0
        val open_time15 = "7AM"
        val close_time15 = "10PM"
        val day_open15 = "7day"
        val day_close15 = "No"
        val image_url15 = "https://i.ibb.co/g7TNGmt/Taco-Bell-Dish-New-shutterstock-1147255865.jpghttps://i.ibb.co/g7TNGmt/Taco-Bell-Dish-New-shutterstock-1147255865.jpg"
        val map_url15 = "https://www.google.com/maps/place/Taco+Bell/@41.980275,-94.3659535,8z/data=!4m8!1m2!2m1!1staco+bell+in+iowa!3m4!1s0x0:0x17193d1fe7c4bd5a!8m2!3d43.1460882!4d-93.3611298"
        val website15 = "https://www.tacobell.com"
        val review15 = "Everyone wearing masks and socially distancing."
        val category_id15 = 1
        val place15 = Place(
            0,
            place_name15,
            place_desc15,
            phone15,
            address15,
            star_point15,
            feature15,
            open_time15,
            close_time15,
            day_open15,
            day_close15,
            image_url15,
            map_url1,
            website15,
            review15,
            category_id15
        )

        val place_name16 = "Domino's"
        val place_desc16 = "Delivery/carryout chain offering a wide range of pizzas & a variety of other dishes & sides."
        val phone16 = "5107964440"
        val address16 = "35248 Newark Blvd, Newark, CA 94560"
        val star_point16 = "4.1"
        val feature16 = 0
        val open_time16 = "7AM"
        val close_time16 = "10PM"
        val day_open16 = "7day"
        val day_close16 = "No"
        val image_url16 = "https://i.ibb.co/wrYcZG5/The-16-000th-Domino-s-store-located-in-Cheektowaga-New-York.jpg"
        val map_url16 = "https://www.google.com/maps/place/Domino's+Pizza/@37.6785064,-122.3725832,10.5z/data=!4m8!1m2!2m1!1sdominos+restaurant!3m4!1s0x0:0xb1712c5a4cb00701!8m2!3d37.5489496!4d-122.0451128?hl=en"
        val website16 = "https://www.dominos.com"
        val review16 = "Everyone wearing masks and socially distancing."
        val category_id16 = 1
        val place16 = Place(
            0,
            place_name16,
            place_desc16,
            phone16,
            address16,
            star_point16,
            feature16,
            open_time16,
            close_time16,
            day_open16,
            day_close16,
            image_url16,
            map_url1,
            website16,
            review16,
            category_id16
        )

        val place_name17 = "Hertz"
        val place_desc17 = "Flexible, risk-free rental solutions"
        val phone17 = "5107979900"
        val address17 = "37063 Fremont Blvd, Fremont, CA 94536"
        val star_point17 = "4.1"
        val feature17 = 0
        val open_time17 = "7AM"
        val close_time17 = "10PM"
        val day_open17 = "7day"
        val day_close17 = "No"
        val image_url17 = "https://i.ibb.co/fpBzmrK/alternativedata-hertz-bankruptcy-full-width-1200x400.jpg"
        val map_url17 = "https://www.google.com/maps/place/Hertz/@37.5380795,-122.0882026,12z/data=!4m8!1m2!2m1!1shertz!3m4!1s0x808fbf99752b8cd9:0xc1c4dc3306c7c415!8m2!3d37.5598032!4d-122.0114254"
        val website17 = "https://www.hertz.com/"
        val review17 = "Everyone wearing masks and socially distancing."
        val category_id17 = 2
        val place17 = Place(
            0,
            place_name17,
            place_desc17,
            phone17,
            address17,
            star_point17,
            feature17,
            open_time17,
            close_time17,
            day_open17,
            day_close1,
            image_url17,
            map_url1,
            website17,
            review17,
            category_id17
        )

        val place_name18 = "Avis car rental"
        val place_desc18 = "Avis Car Rental and its subsidiaries operate one of the world's best-known car rental brands with approximately 5,500 locations in more than 165 countries."
        val phone18 = "5107131006"
        val address18 = "5307 Central Ave, Fremont, CA 94536"
        val star_point18 = "4.1"
        val feature18 = 0
        val open_time18 = "7AM"
        val close_time18 = "10PM"
        val day_open18 = "7day"
        val day_close18 = "No"
        val image_url18 = "https://i.ibb.co/XxKFRjW/go1ep49rwhec8ygdcfxn.webp"
        val map_url18 = "https://www.google.com/maps/place/Avis+Car+Rental/@37.5380174,-122.158247,11z/data=!4m8!1m2!2m1!1savis+car+rental!3m4!1s0x808fbf129830074d:0x5589f7908e57323!8m2!3d37.540425!4d-122.017331"
        val website18 = "https://www.avis.com"
        val review18 = "Everyone wearing masks and socially distancing."
        val category_id18 = 2
        val place18 = Place(
            0,
            place_name18,
            place_desc18,
            phone18,
            address18,
            star_point18,
            feature18,
            open_time18,
            close_time18,
            day_open18,
            day_close18,
            image_url18,
            map_url18,
            website18,
            review18,
            category_id18
        )

        val place_name19 = "Payless car rental"
        val place_desc19 = "Payless Car Rental, Inc. is a car rental company owned by Avis Budget Group and headquartered in St. Petersburg, Florida."
        val phone19 = "4087244400"
        val address19 = "1659 Airport Blvd Suite 12, San Jose, CA 95110"
        val star_point19 = "4.1"
        val feature19 = 0
        val open_time19 = "7AM"
        val close_time19 = "10PM"
        val day_open19 = "7day"
        val day_close19 = "No"
        val image_url19 = "https://i.ibb.co/KzpBHHd/who-owns-payless-car-rental.jpg"
        val map_url19 = "https://www.google.com/maps/place/Payless+Car+Rental/@37.365185,-122.0625677,11z/data=!3m1!5s0x808fcb95ba2c751f:0xa7adc41365851060!4m8!1m2!2m1!1spayless+car+rental!3m4!1s0x808fcb95724e25e1:0x5942dc0fb94246f5!8m2!3d37.365185!4d-121.922492"
        val website19 = "https://www.paylesscar.com"
        val review19 = "Everyone wearing masks and socially distancing."
        val category_id19 = 2
        val place19 = Place(
            0,
            place_name19,
            place_desc19,
            phone19,
            address19,
            star_point19,
            feature19,
            open_time19,
            close_time19,
            day_open19,
            day_close19,
            image_url19,
            map_url19,
            website19,
            review19,
            category_id19
        )

        val place_name20 = "Alamo car rental"
        val place_desc20 = "Alamo Rent a Car is a car rental agency in the United States. Based in Clayton, Missouri, it has branches across North America, South America, Africa, Europe, Asia, Australia and Oceania."
        val phone20 = "8443708303"
        val address20 = "1659 Airport Blvd Suite 5, San Jose, CA 95110"
        val star_point20 = "4.1"
        val feature20 = 0
        val open_time20 = "7AM"
        val close_time20 = "10PM"
        val day_open20 = "7day"
        val day_close20 = "No"
        val image_url20 = "https://i.ibb.co/ryrzCkC/1.jpg"
        val map_url20 = "https://www.google.com/maps/place/Alamo+Rent+A+Car/@37.3650024,-122.1588724,10z/data=!4m8!1m2!2m1!1salamo+car+rental!3m4!1s0x808fcb942b5d8921:0x4c002ef5203330a!8m2!3d37.3650024!4d-121.9232941"
        val website20 = "https://www.alamo.com"
        val review20 = "Everyone wearing masks and socially distancing."
        val category_id20 = 2
        val place20 = Place(
            0,
            place_name20,
            place_desc20,
            phone20,
            address20,
            star_point20,
            feature20,
            open_time20,
            close_time20,
            day_open20,
            day_close20,
            image_url20,
            map_url20,
            website20,
            review20,
            category_id20
        )

        val place_name21 = "Marriot Hotel"
        val place_desc21 = "Marriott International, Inc. is an American multinational diversified hospitality company that manages and franchises a broad portfolio of hotels and related lodging facilities."
        val phone21 = "5107925200"
        val address21 = "34905 Newark Blvd, Newark, CA 94560"
        val star_point21 = "4.1"
        val feature21 = 0
        val open_time21 = "7AM"
        val close_time21 = "10PM"
        val day_open21 = "7day"
        val day_close21 = "No"
        val image_url21 = "https://i.ibb.co/sgCbbTT/2171-19052910290074789701.jpg"
        val map_url21 = "https://www.google.com/maps/place/Courtyard+by+Marriott+Newark+Silicon+Valley/@37.538095,-122.0531821,13z/data=!4m11!1m2!2m1!1smarriott+hotels!3m7!1s0x808fbe4511429fbb:0x5cab9deca0b9408a!5m2!4m1!1i2!8m2!3d37.5500206!4d-122.0524725"
        val website21 = "https://www.marriott.com"
        val review21 = "Everyone wearing masks and socially distancing."
        val category_id21 = 3
        val place21 = Place(
            0,
            place_name21,
            place_desc21,
            phone21,
            address21,
            star_point21,
            feature21,
            open_time21,
            close_time21,
            day_open21,
            day_close21,
            image_url21,
            map_url21,
            website21,
            review21,
            category_id21
        )

        val place_name22 = "Hilton Hotel"
        val place_desc22 = "Hilton Worldwide Holdings Inc., formerly Hilton Hotels Corporation, is an American multinational hospitality company that manages and franchises a broad portfolio of hotels and resorts."
        val phone22 = "4084966400"
        val address22 = "2885 Lakeside Dr, Santa Clara, CA 95054"
        val star_point22 = "4.1"
        val feature22 = 0
        val open_time22 = "7AM"
        val close_time22 = "10PM"
        val day_open22 = "7day"
        val day_close22 = "No"
        val image_url22 = "https://i.ibb.co/ryrzCkC/1.jpg"
        val map_url22 = "https://www.google.com/maps/place/Embassy+Suites+by+Hilton+Santa+Clara+Silicon+Valley/@37.4214647,-122.0119191,10.5z/data=!4m11!1m2!2m1!1shilton+hotels!3m7!1s0x808fc9ef27281899:0xd9c9dcfe26b38ac2!5m2!4m1!1i2!8m2!3d37.3839591!4d-121.9786423"
        val website22 = "https://www.hilton.com"
        val review22 = "Everyone wearing masks and socially distancing."
        val category_id22 = 3
        val place22 = Place(
            0,
            place_name22,
            place_desc22,
            phone22,
            address22,
            star_point22,
            feature22,
            open_time22,
            close_time22,
            day_open22,
            day_close22,
            image_url22,
            map_url22,
            website22,
            review22,
            category_id22
        )

        val place_name23 = "Ramada Hotel"
        val place_desc23 = "Ramada is a large American multinational hotel chain owned by Wyndham Hotels and Resorts. As of December 31, 2018, it operates 811 hotels with 114,614 rooms across 63 countries under the Ramada brand."
        val phone23 = "4087387473"
        val address23 = "1217 Wildwood Ave, Sunnyvale, CA 94089"
        val star_point23 = "4.1"
        val feature23 = 0
        val open_time23 = "7AM"
        val close_time23 = "10PM"
        val day_open23 = "7day"
        val day_close23 = "No"
        val image_url23 = "https://i.ibb.co/3z7BKCG/135131912.jpg"
        val map_url23 = "https://www.google.com/maps/place/Ramada+by+Wyndham+Sunnyvale%2FSilicon+Valley/@37.2020416,-122.9207201,9.25z/data=!3m1!5s0x808fc9d8a2d886f7:0xff313f56c41c53ac!4m11!1m2!2m1!1sramada!3m7!1s0x808fc9d8a35c9ac5:0x63566488f4f83195!5m2!4m1!1i2!8m2!3d37.3909741!4d-121.9923192"
        val website23 = "https://www.wyndhamhotels.com/ramada"
        val review23 = "Everyone wearing masks and socially distancing."
        val category_id23 = 3
        val place23 = Place(
            0,
            place_name23,
            place_desc23,
            phone23,
            address23,
            star_point23,
            feature23,
            open_time23,
            close_time23,
            day_open23,
            day_close23,
            image_url23,
            map_url23,
            website23,
            review23,
            category_id23
        )

        val place_name24 = "Walmart store"
        val place_desc24 = "Walmart Inc. is an American multinational retail corporation that operates a chain of hypermarkets, discount department stores, and grocery stores, headquartered in Bentonville, Arkansas."
        val phone24 = "6509170796"
        val address24 = "600 Showers Dr, Mountain View, CA 94040"
        val star_point24 = "4.1"
        val feature24 = 0
        val open_time24 = "7AM"
        val close_time24 = "10PM"
        val day_open24 = "7day"
        val day_close24 = "No"
        val image_url24 = "https://i.ibb.co/9N1gYj6/download.jpg"
        val map_url24 = "https://www.google.com/maps/place/Walmart/@37.4007514,-122.1448581,13z/data=!4m8!1m2!2m1!1swalmart!3m4!1s0x808fb09902fa21af:0x64684098271e4fc7!8m2!3d37.4007514!4d-122.1098392"
        val website24 = "https://www.walmart.com"
        val review24 = "Everyone wearing masks and socially distancing."
        val category_id24 = 5
        val place24 = Place(
            0,
            place_name24,
            place_desc24,
            phone24,
            address24,
            star_point24,
            feature24,
            open_time24,
            close_time24,
            day_open24,
            day_close24,
            image_url24,
            map_url24,
            website24,
            review24,
            category_id24
        )

        val place_name25 = "Maharishi International University"
        val place_desc25 = "Maharishi International University, formerly Maharishi University of Management, is a private university in Fairfield, Iowa."
        val phone25 = "4087387473"
        val address25= "1000 N 4th St, Fairfield, IA 52557"
        val star_point25 = "4.1"
        val feature25 = 0
        val open_time25 = "7AM"
        val close_time25 = "10PM"
        val day_open25 = "7day"
        val day_close25 = "No"
        val image_url25 = "https://i.ibb.co/SsdJR5z/1538997646php-PHAk-Dx.png"
        val map_url25 = "https://www.google.com/maps/place/Maharishi+International+University/@41.017765,-91.9694788,17z/data=!3m1!4b1!4m5!3m4!1s0x87e666733021a1fd:0xbd109f9c0f5e4fce!8m2!3d41.017765!4d-91.9672901"
        val website25 = "https://www.miu.edu/"
        val review25 = "Everyone wearing masks and socially distancing."
        val category_id25 = 4
        val place25 = Place(
            0,
            place_name25,
            place_desc25,
            phone25,
            address25,
            star_point25,
            feature25,
            open_time25,
            close_time25,
            day_open25,
            day_close25,
            image_url25,
            map_url25,
            website25,
            review25,
            category_id25
        )

        mPlaceViewModel.addPlace(place)
        mPlaceViewModel.addPlace(place1)
        mPlaceViewModel.addPlace(place3)
        mPlaceViewModel.addPlace(place4)
        mPlaceViewModel.addPlace(place5)
        mPlaceViewModel.addPlace(place6)
        mPlaceViewModel.addPlace(place7)
        mPlaceViewModel.addPlace(place9)
        mPlaceViewModel.addPlace(place10)
        mPlaceViewModel.addPlace(place11)
        mPlaceViewModel.addPlace(place12)
        mPlaceViewModel.addPlace(place13)
        mPlaceViewModel.addPlace(place14)
        mPlaceViewModel.addPlace(place15)
        mPlaceViewModel.addPlace(place16)
        mPlaceViewModel.addPlace(place17)
        mPlaceViewModel.addPlace(place18)
        mPlaceViewModel.addPlace(place19)
        mPlaceViewModel.addPlace(place20)
        mPlaceViewModel.addPlace(place21)
        mPlaceViewModel.addPlace(place22)
        mPlaceViewModel.addPlace(place23)
        mPlaceViewModel.addPlace(place24)
        mPlaceViewModel.addPlace(place25)

        Toast.makeText(this, "Create Place Successful !!!!", Toast.LENGTH_SHORT).show()
    }

}