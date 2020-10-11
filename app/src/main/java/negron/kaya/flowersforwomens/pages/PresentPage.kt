package negron.kaya.flowersforwomens.pages

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import negron.kaya.flowersforwomens.R

typealias ClickPresent = () -> Unit

class PresentPage: Fragment(R.layout.present_page) {

    lateinit var clickPresent: ClickPresent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<Button>(R.id.btn_present).setOnClickListener {
            clickPresent()
        }
    }
}