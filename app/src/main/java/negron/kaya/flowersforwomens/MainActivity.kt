package negron.kaya.flowersforwomens

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import negron.kaya.flowersforwomens.adapter.ViewPagerAdapter
import negron.kaya.flowersforwomens.pages.*

private const val MAX_PAGES = 5
private const val INITIAL_PAGE_POSITION = 0

class MainActivity : AppCompatActivity() {

    private val viewPagerAdapter by lazy { ViewPagerAdapter(supportFragmentManager) }
    private val viewPager: ViewPager by lazy { findViewById(R.id.view_pager) }
    private val radioGroup: RadioGroup by lazy { findViewById(R.id.radio_group) }

    private val presentPage: PresentPage by lazy {
        PresentPage().apply { clickPresent = ::goToFlower }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewPager()
        radioGroup.check(radioGroup.getChildAt(INITIAL_PAGE_POSITION).id)
    }

    private fun setUpViewPager() {
        viewPagerAdapter.fragmentList = getFragmentList()
        viewPager.apply {
            adapter = viewPagerAdapter
            offscreenPageLimit = MAX_PAGES
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                radioGroup.check(radioGroup.getChildAt(position).id)
            }

            override fun onPageScrollStateChanged(state: Int) { }
        })
    }

    private fun getFragmentList() = listOf(
        GreetingPage(), WhyPage(), ResourcePage(), presentPage, FlowerPage()
    )

    private fun goToFlower() {
        viewPager.setCurrentItem(MAX_PAGES, true)
    }
}