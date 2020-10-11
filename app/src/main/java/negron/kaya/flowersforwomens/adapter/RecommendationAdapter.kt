package negron.kaya.flowersforwomens.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import negron.kaya.flowersforwomens.R
import negron.kaya.flowersforwomens.models.Recommendation
import kotlin.properties.Delegates

class RecommendationAdapter: RecyclerView.Adapter<RecommendationHolder>() {

    var recommendations: List<Recommendation> by Delegates.observable(emptyList()) {_,_,_ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendation, parent, false)
        return RecommendationHolder(layout)
    }

    override fun onBindViewHolder(holder: RecommendationHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size
}

class RecommendationHolder(private val rootView: View): RecyclerView.ViewHolder(rootView) {

    fun bind(recommendation: Recommendation) {
        rootView.apply {
            findViewById<TextView>(R.id.text_type).apply {
                text = recommendation.type
            }
            findViewById<TextView>(R.id.title).apply {
                text = recommendation.title
            }
            setOnClickListener { redirection(rootView.context, recommendation.url) }
        }
    }

    private fun redirection(context: Context, url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            context.startActivity(this)
        }
    }
}