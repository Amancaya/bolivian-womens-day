package negron.kaya.flowersforwomens.models

import com.fasterxml.jackson.annotation.JsonProperty

enum class RecommendationType {
    Podcast, Video, Blog, Telegram;

    companion object {
        fun from(type: String): RecommendationType = values().first { it.name == type }
    }
}

data class Response(
    @JsonProperty("resources")
    val resources: List<Recommendation>
)

data class Recommendation(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("url")
    val url: String,
    @JsonProperty("type")
    val type: String
) {
    fun getEnumType(): RecommendationType = RecommendationType.from(type)
}