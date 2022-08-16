package com.example.tourismproject.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.tourismproject.R
import com.google.android.material.button.MaterialButton
import kotlin.properties.Delegates

class PlacesActivity : AppCompatActivity() {


    lateinit var image : ImageView
    lateinit var placeName : TextView
    lateinit var description : TextView
    lateinit var placePrice : TextView
    lateinit var days : TextView
    lateinit var bookBtn : MaterialButton


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)

        image = findViewById(R.id.PlaceImage)
        placeName = findViewById(R.id.placeName)
        description = findViewById(R.id.description)
        placePrice = findViewById(R.id.placePrice)
        days = findViewById(R.id.days)
        bookBtn = findViewById(R.id.bookTicketBtn)

        val bundle : Bundle? = intent.extras


        try {
            val place : String? = intent.getStringExtra("PLACENAME")
            val price : Int = intent.getIntExtra("PRICE",0)
            placeName.text = place
            placePrice.text = price.toString()
            val img : Int? = bundle?.getInt("IMAGE")
            if (img != null) {
                image.setImageResource(img)
            }
        }
        catch (e : Exception){
            e.printStackTrace()
        }



//        for changing description
        if (placeName.text.toString().equals("Pavagadh")){
            days.text = "${3}"
            description.text = " Pavagadh is an ancient Triassic Period location with Enriched History from periods of Treta Yuga and Dvapara Yuga.[citation needed]\\n\" +\n" +
                    "\"In present day, Pavagadh is a municipal operated region in Panchmahal district about 46 kilometres (29 mi) away from Vadodara in Gujarat state in western India. \" +\n" +
                    "\"It is known for a famous Mahakali temple which draws thousands of pilgrims every day. It is a tribal area populated predominantly by the Rathwas."
        }

        else if (placeName.text.toString().equals("Science City")){
            days.text = "${1}"
            description.text = "Gujarat Science City is a science education and entertainment centre located in Ahmedabad, Gujarat, India. \" +\n" +
                    "\"Opened in 2002, it has an IMAX 3D theatre; exhibitions on science, space, energy, life sciences, plants, nature and robotics; \" +\n" +
                    "\"an aquarium, an aviary and a butterfly park; as well as other facilities."
        }

        else if (placeName.text.toString().equals("RaniKi Vav")){
            days.text = "${2}"
            description.text = "  Rani Ki Vav is a stepwell situated in the town of Patan in Gujarat state of India.\" +\n" +
                    "\" It is located on the banks of Saraswati river. Its construction is attributed to Udayamati, daughter of Khengara of Saurashtra, \" +\n" +
                    "\"queen and spouse of the 11th-century Chaulukya king Bhima I. Silted over, it was rediscovered in 1940s and restored in 1980s by the \" +\n" +
                    "\"Archaeological Survey of India."
        }

        else if (placeName.text.toString().equals("Modhera Temple")){
            days.text = "${2}"
            description.text = "he Sun Temple is a Hindu temple dedicated to the solar deity Surya located at Modhera village of Mehsana district, Gujarat, India.\n" +
                    "It is situated on the bank of the river Pushpavati. It was built after 1026-27 CE during the reign of Bhima I of the Chaulukya dynasty.\n" +
                    "No worship is offered now and is protected monument maintained by Archaeological Survey of India."
        }

        else if (placeName.text.toString().equals("Somnath Temple")){
            days.text = "${3}"
            description.text = "The Somnath temple, also called Somanātha temple or Deo Patan, is a Hindu temple located in Prabhas Patan, Veraval in Gujarat,India.\n" +
                    "It is one of the most sacred pilgrimage sites for Hindus and is believed to be first among the twelve jyotirlinga shrines of Shiva.\n" +
                    "The temple was reconstructed several times in the past after repeated destruction by multiple Muslim invaders and rulers,\n" +
                    "notably starting from an attack by Mahmud Ghazni in the 11th century."
        }

        else if (placeName.text.toString().equals("Vadodara museum")){
            days.text = "${2}"
            description.text = "The Baroda Museum, Picture Gallery in Vadodara was built in 1894 on the lines of the Victoria,Albert Museum\n" +
                    "and the Science Museum of London. Major Mant in association with R.F.Chisholm who refined some of Mant's\n" +
                    "finest works to make genuine Indo-Saracenic architecture designed the Building of this Museum."
        }

        else if (placeName.text.toString().equals("Flower Garden")){
            days.text = "${1}"
            description.text = "A flower garden or floral garden is any garden or part of a garden where plants that flower are grown and displayed.\n" +
                    "This normally refers mostly to herbaceous plants, rather than flowering woody plants, which dominate in the shrubbery and woodland garden,\n" +
                    "although both these types may be part of the planting in any area of the garden."
        }

        else if (placeName.text.toString().equals("Statue of Unity")){
            days.text = "${2}"
            description.text = "The Statue of Unity is the world\\'s tallest statue, with a height of 182 metres (597 feet),[3] located in the state of Gujarat, India.\n" +
                    "It depicts Indian statesman and independence activist Vallabhbhai Patel (1875–1950), who was the first deputy prime minister and home\n" +
                    "minister of independent India and an adherent of Mahatma Gandhi. Patel was highly respected for his leadership in uniting 562 princely\n" +
                    "states of India to form the single Union of India. In Gujarat the statue is found on the Narmada River in the Kevadiya colony, facing the\n" +
                    "Sardar Sarovar Dam 100 kilometres (62 mi) southeast of the city of Vadodara."
        }

        else if (placeName.text.toString().equals("Narmada River")){
            days.text = "${2}"
            description.text = " The Sardar Sarovar Dam is a concrete gravity dam built on the Narmada river in Navagam near the town of Kevadiya, Narmada District,\n" +
                    "in the state of Gujarat, India. The dam was constructed to provide water and electricity to four Indian states; Gujarat, Madhya Pradesh,\n" +
                    "Maharashtra, and Rajasthan."
        }

        else if (placeName.text.toString().equals("Gopi Talav")){
            days.text = "${1}"
            description.text = "  Gopi Talav or Gopi Lake is a lake in the Gopipura locality in the city of Surat in Gujarat state of India.\n" +
                    "It was built in circa 1510 CE by Malik Gopi, who was an affluent merchant and governor of Surat during the Gujarat Sultanate.\n" +
                    "In 2012, the lake was renovated by Surat Municipal Corporation and the area surrounding it was redeveloped as a recreational facility."
        }

        else if (placeName.text.toString().equals("Dumas Beach")){
            days.text = "${1}"
            description.text = " Dumas Beach is a rural beach along the Arabian Sea, located 21 kilometres (13 mi) southwest of the city of Surat in the Indian state of\n" +
                    "Gujarat. It is a popular tourist destination in South Gujarat. Dumas Beach is justly famous for being in the top 35 haunted spots in\n" +
                    "India. Dumas beach is known for its black sand and is considered to be haunted because it was once used as a Hindu burial site, according to folklore"
        }

        else if (placeName.text.toString().equals("Iskcon surat temple")){
            days.text = "${1}"
            description.text = " Iskcon temple, locally known as Shri Shri Radha Damodar Mandir, has been founded by the Iskcon foundation in 1978.\n" +
                    "Its construction was preceded by the visit of Shrila Prabhupada, Iskcon’s founder Acharya, in 1970.\n" +
                    "Initially the area of the temple was limited to about 900 sq. ft. but over time the temple complex has been extended\n" +
                    "up to 13,600 sq. feet. Located a little away from the centre of the city and placed near the banks of Tapi River,\n" +
                    "the temple takes one away from the hustle and bustle of city life."
        }

        else if (placeName.text.toString().equals("Taj Mahal")){
            days.text = "${5}"
            description.text = "No description available"
        }

        else if (placeName.text.toString().equals("Goa Beaches")){
            days.text = "${10}"
            description.text = "  The state of Goa, in India, is famous for its beaches and places of worship. Tourism is its primary industry,\n" +
                    "and is generally focused on the coastal areas of Goa, with decreased tourist activity inland.\n" +
                    "Foreign tourists, mostly from Europe, arrive in Goa in winter, whilst the summer and monsoon seasons see many Indian tourists.\n" +
                    "Goa handled 2.29% of all foreign tourist arrivals in the country in 2011."
        }

        else if (placeName.text.toString().equals("Mayapur Iskcon")){
            days.text = "${7}"
            description.text = "Mayapur (Mayāpura), previously known as Miyapur,[1] is a neighbourhood of Bamanpukur, in the Nabadwip CD block in the\n" +
                    "Krishnanagar Sadar subdivision of the Nadia district in the state of West Bengal, India. It is situated adjacent to Nabadwip,\n" +
                    "at the confluence of two rivers, where the waters of the Jalangi River mix with Bhagirathi, a distributary of the Ganges."
        }

        else if (placeName.text.toString().equals("Jammu Kashmir")){
            days.text = "${6}"
            description.text = " Jammu and Kashmir is home to several valleys such as the Kashmir Valley, Chenab Valley, Sindh Valley and Lidder Valley.\n" +
                    "Some major tourist attractions in Jammu and Kashmir are Srinagar, with its renowned Dal Lake and Mughal Gardens, Gulmarg, Pahalgam,\n" +
                    "Patnitop and Jammu. Every year,thousands of Hindu pilgrims visit holy shrines of Vaishno Devi and Amarnath which has had a significant\n" +
                    "impact on the state's economy."
        }

        else if (placeName.text.toString().equals("Amarnath")){
            days.text = "${9}"
            description.text = " Amarnath Temple is a Hindu shrine located in Anantnag district of the Jammu and Kashmir, India.\n" +
                    "The cave is situated at an altitude of 3,888 m (12,756 ft),[1] about 168 km from Anantnag city, the district headquarter,\n" +
                    "141 km (88 mi) from Srinagar, the summer capital of Jammu and Kashmir,\n" +
                    "reached through Pahalgam town. The shrine represents an important part of Hinduism"
        }

        else if (placeName.text.toString().equals("Kedarnath")){
            days.text = "${7}"
            description.text = " Kedarnath is a town in Rudraprayag district in the state of Uttarakhand in India and has gained importance because of the Kedarnath\n" +
                    "Temple. It is approximately 86 kilometres from Rudraprayag, the district headquarter. It is a Nagar panchayat in the Rudraprayag district.\n" +
                    "Kedarnath is the most remote of the four Chota Char Dham pilgrimage sites. It is located in the Himalayas, about 3,583 m\n" +
                    "(11,755 ft) above sea level near the Chorabari Glacier, which is the source of the Mandakini river."
        }

        bookBtn.setOnClickListener {
            val price : String = placePrice.text.toString()
            val place : String = placeName.text.toString()
            val day : String = days.text.toString()

            val newPrice : Int = Integer.parseInt(price)

            val i = Intent(applicationContext,TicketActivity::class.java)
            i.putExtra("Place",place)
            i.putExtra("Price",newPrice)
            i.putExtra("Days",day)
            startActivity(i)
        }
    }
}