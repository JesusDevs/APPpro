
import com.google.gson.annotations.SerializedName

data class loginResponseX(
    @SerializedName("api-token")
    val apiToken: String,
    @SerializedName("STATUS")
    val sTATUS: String
)