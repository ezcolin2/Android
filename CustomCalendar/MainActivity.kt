class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKakaoLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val calendarView=binding.calendarView
        val arrayList = ArrayList<CalendarDay>()
        val mydate= CalendarDay.from(2023,  5, 8) // year, month, date
        val mydate2= CalendarDay.from(2023,  5, 10) // year, month, date
        arrayList.add(mydate)
        arrayList.add(mydate2)
        calendarView.addDecorators(CurrentDayDecorator(this@MainActivity, arrayList))
    }

}
