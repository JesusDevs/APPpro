
import com.google.gson.annotations.SerializedName

data class loginResponse(
    @SerializedName("api-token")
    val apiToken: String,
    @SerializedName("STATUS")
    val sTATUS: String
)