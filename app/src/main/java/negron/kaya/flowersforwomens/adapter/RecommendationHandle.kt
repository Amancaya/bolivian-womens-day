package negron.kaya.flowersforwomens.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import negron.kaya.flowersforwomens.R
import negron.kaya.flowersforwomens.models.Recommendation
import negron.kaya.flowersforwomens.models.RecommendationType

object RecommendationHandle {

    fun startIntent(recommendation: Recommendation, context: Context) =
        when(recommendation.getEnumType()) {
            RecommendationType.Telegram -> Intent(Intent.ACTION_VIEW, Uri.parse(recommendation.url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(this)
            }
            else -> Intent(Intent.ACTION_VIEW, Uri.parse(recommendation.url)).apply {
                context.startActivity(this)
            }
        }

    fun loadImage(recommendation: Recommendation, imageView: ImageView) {
        try {
            when(recommendation.getEnumType()) {
                RecommendationType.Podcast -> imageView.setImageResource(R.drawable.ic_podcast)
                RecommendationType.Video -> imageView.setImageResource(R.drawable.ic_video)
                RecommendationType.Blog -> imageView.setImageResource(R.drawable.ic_web)
                RecommendationType.Telegram -> imageView.setImageResource(R.drawable.ic_book)
            }
        }catch (e: Exception) {
            imageView.setImageResource(R.drawable.ic_podcast)
        }
    }
}