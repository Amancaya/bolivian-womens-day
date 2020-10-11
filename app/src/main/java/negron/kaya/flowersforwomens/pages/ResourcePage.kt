package negron.kaya.flowersforwomens.pages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.fasterxml.jackson.databind.ObjectMapper
import negron.kaya.flowersforwomens.DataHandle
import negron.kaya.flowersforwomens.R
import negron.kaya.flowersforwomens.adapter.RecommendationAdapter
import negron.kaya.flowersforwomens.models.Response

class ResourcePage: Fragment(R.layout.resource_page)  {

    private val listRecommendation: RecyclerView by lazy { requireView().findViewById(R.id.list_recommendation) }
    private val adapter: RecommendationAdapter by lazy { RecommendationAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.recommendations = DataHandle.getListRecommendation(requireContext())
        listRecommendation.adapter = adapter
    }
}