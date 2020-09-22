package LoginSignup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.model.Categories
import com.lukpheakdey.cityguideapp.model.Place
import com.lukpheakdey.cityguideapp.viewmodel.CategoriesViewModel
import com.lukpheakdey.cityguideapp.viewmodel.PlaceViewModel
import com.lukpheakdey.cityguideapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    private lateinit var mCategoriesViewModel: CategoriesViewModel

    private lateinit var mPlaceViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        btn_login.setOnClickListener {
            val email = et_login_email.editText?.text.toString().trim()
            val password = et_login_password.editText?.text.toString().trim()

//            mUserViewModel.readAllData.observe(this, Observer { user ->
//                println("***** READ ALL DATA ******")
//                println(user)
//            })

            if(inputCheck(email, password)){
                var me = mUserViewModel.findUserByEmailPassword(email, password)
                Toast.makeText(this, "Sucessfully login", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }


        //simple to create category
        btn_create_category.setOnClickListener {
            val name = "Reaturant"
            val desc = "Restaurant place have to go for eatting"
            val image = "restaurant_image"
            val color = "#d4cbe5"

            val name1 = "Car Rents"
            val desc1 = "Car Rents place to visit in this city"
            val image1 = "transport_image"
            val color1 = "#947AE8"

            val name2 = "Hotels"
            val desc2 = "The best sleeping place"
            val image2 = "vlog"
            val color2 = "#7adccf"

            val name3 = "Education"
            val desc3 = "School and unviersity"
            val image3 = "school_image"
            val color3 = "#f7c59f"

            val name4 = "Shops"
            val desc4 = "There are alot mall around here"
            val image4 = "shopping_image"
            val color4 = "#b8d7f5"

            val category = Categories(0, name, desc, image, color)
            val category1 = Categories(0, name1, desc1, image1, color1)
            val category2 = Categories(0, name2, desc2, image2, color2)
            val category3 = Categories(0, name3, desc3, image3, color3)
            val category4 = Categories(0, name4, desc4, image4, color4)
            mCategoriesViewModel.addCategory(category)
            mCategoriesViewModel.addCategory(category1)
            mCategoriesViewModel.addCategory(category2)
            mCategoriesViewModel.addCategory(category3)
            mCategoriesViewModel.addCategory(category4)
            Toast.makeText(this, "Create category!!!!", Toast.LENGTH_SHORT).show()
        }

        //Simple input Place to table
        btn_create_place.setOnClickListener {
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
                review7,
                category_id7
            )

            val place_name8= "Best Western Potomac Mills"
            val place_desc8 = "Modest hotel with complimentary breakfast & parking, plus an outdoor pool & a fitness center."
            val phone8 = "(703) 494-4433"
            val address8 = "14619 Potomac Mills Rd, Woodbridge, VA 22192"
            val star_point8 = "3.9"
            val feature8 = 1
            val open_time8 = "24Hour"
            val close_time8 = "No"
            val day_open8 = "7day"
            val day_close8 = "No"
            val image_url8 = "https://i.ibb.co/JR6Td9x/best-western-hotel.jpg"
            val map_url8 = "https://www.google.com/maps?gl=US&hl=en&um=1&ie=UTF-8&fb=1&sa=X&geocode=KTOGji8FVraJMRwNJJVINOjV&daddr=Best+Western+Potomac+Mills,+14619+Potomac+Mills+Rd,+Woodbridge,+VA+22192"
            val review8 = "Part of the Potomac Mills shopping mall, this unpretentious hotel off I-95 is 5 miles from Occoquan Bay National Wildlife Refuge and 9 miles from the National Museum of the Marine Corps."
            val category_id8 = 3
            val place8 = Place(
                0,
                place_name8,
                place_desc8,
                phone8,
                address8,
                star_point8,
                feature8,
                open_time8,
                close_time8,
                day_open8,
                day_close8,
                image_url8,
                map_url8,
                review8,
                category_id8
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
                review12,
                category_id12
            )

            mPlaceViewModel.addPlace(place)
            mPlaceViewModel.addPlace(place1)
            mPlaceViewModel.addPlace(place3)
            mPlaceViewModel.addPlace(place4)
            mPlaceViewModel.addPlace(place5)
            mPlaceViewModel.addPlace(place6)
            mPlaceViewModel.addPlace(place7)
            mPlaceViewModel.addPlace(place8)
            mPlaceViewModel.addPlace(place9)
            mPlaceViewModel.addPlace(place10)
            mPlaceViewModel.addPlace(place11)
            mPlaceViewModel.addPlace(place12)
            Toast.makeText(this, "Create Place Successful !!!!", Toast.LENGTH_SHORT).show()
        }

        // Test Open browner
        open_wesite.setOnClickListener {
            Toast.makeText(this, "Open Website", Toast.LENGTH_SHORT).show()
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(browserIntent)
        }

        // Test for make call
        dail_call.setOnClickListener {
            val TELEPHONE_SCHEMA = "tel:"
            val PRESERVED_CHARACTER = "+"
            val HK_COUNTRY_CODE = "1"
            val HK_OBSERVATORY_PHONE_NUMBER = "7034746127"
            val phoneCallUri = Uri.parse(TELEPHONE_SCHEMA + PRESERVED_CHARACTER + HK_COUNTRY_CODE + HK_OBSERVATORY_PHONE_NUMBER)

            val phoneCallIntent = Intent(Intent.ACTION_DIAL).also{
                it.setData(phoneCallUri)
            }
            startActivity(phoneCallIntent)

            Toast.makeText(this, "Dail call", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }
}