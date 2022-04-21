main(){
	val sessionId: String = "sessionid=dj91qclmxmd2pligzxxxnj7a9ndl8c3n; Path=/; HttpOnly; Expires=Sun, 24 Apr 2022 14:56:46 GMT;"
    val csrf = "csrftoken=B7do7s94UGlKqX2TUqxGlOcKaHNLEmhQbNaTKJsbYumQ5wIhY8cpjPa5mZ4moeMm; Path=/; Expires=Sun, 09 Apr 2023 14:56:45 GMT;"

    fun getExpiry(sessionData: String) : String? {
        val expiry : String? = null
        val arr = sessionData.split(";")
        for (value in arr){
            if (value.startsWith(" Expires")){
                val expiryList = value.split("=")
                return expiryList[1]
            }
        }
        return expiry
    }

    fun getName(sessionData: String) : String?{
        var name: String? = null
        val data = sessionData.split(";")
        for (value in data){
            if (value.startsWith("sessionid")){
                name = "sessionId"
            }
            if (value.startsWith("csrftoken")){
                name = "csrfToken"
            }
        }
        return name
    }

    val name = getName(sessionId)
    val date = getExpiry(sessionId)
    println(name)
    println(date)
    val n = getName(csrf)
    val d = getExpiry(csrf)
    println(n)
    println(d)
}
