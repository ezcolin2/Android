
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appBar : AppBarConfiguration
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = binding.container.getFragment<NavHostFragment>().navController//navController 세팅
        appBar = AppBarConfiguration( //appBarConfiguration 세팅
            setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment), //top-level fragment
            binding.drawerLayout //drawerLayout
        )
        setupActionBarWithNavController(navController,appBar)
        binding.drawer.setupWithNavController(binding.container.getFragment<NavHostFragment>().navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBar) || super.onSupportNavigateUp()
    }
}
