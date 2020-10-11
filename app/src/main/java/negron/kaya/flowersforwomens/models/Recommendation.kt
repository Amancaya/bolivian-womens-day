package negron.kaya.flowersforwomens.models

import com.fasterxml.jackson.annotation.JsonProperty

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
)