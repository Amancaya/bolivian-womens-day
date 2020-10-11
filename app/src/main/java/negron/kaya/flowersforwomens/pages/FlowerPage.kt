package negron.kaya.flowersforwomens.pages

import android.animation.Animator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import negron.kaya.flowersforwomens.R

class FlowerPage: Fragment(R.layout.flower_page) {

    private val rose: LottieAnimationView by lazy {
        requireView().findViewById(R.id.animation_roses)
    }

    private val fireworks: LottieAnimationView by lazy {
        requireView().findViewById(R.id.animation_fireworks)
    }

    override fun onResume() {
        super.onResume()
        rose.playAnimation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<View>(R.id.github_layout).setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Amancaya/bolivian-womens-day")).apply {
                requireActivity().startActivity(this)
            }
        }

        rose.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) { }
            override fun onAnimationEnd(p0: Animator?) {
                fireworks.playAnimation()
            }
            override fun onAnimationCancel(p0: Animator?) { }
            override fun onAnimationRepeat(p0: Animator?) { }
        })
    }
}