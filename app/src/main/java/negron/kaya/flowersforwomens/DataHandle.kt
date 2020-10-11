package negron.kaya.flowersforwomens

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import negron.kaya.flowersforwomens.models.Recommendation
import negron.kaya.flowersforwomens.models.Response

object DataHandle {

    fun getListRecommendation(context: Context): List<Recommendation> {
        val readFile = context.resources.openRawResource(R.raw.recommendations)
        val mapper = ObjectMapper()
        return mapper.readValue(readFile, Response::class.java).resources
    }
}