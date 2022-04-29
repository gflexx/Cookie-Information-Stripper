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
    
    /// using and convertion of date formats in 
    
    val dateVals = "EEE : Day ( Mon )\n" +
            "MMM : Month in words ( Dec )\n" +
            "MM : Day in Count ( 324 )\n" +
            "mm : Month ( 12 )\n" +
            "dd : Date ( 3 )\n" +
            "HH : Hours ( 12 )\n" +
            "mm : Minutes ( 50 )\n" +
            "ss : Seconds ( 34 )\n" +
            "yyyy: Year ( 2020 ) //both yyyy and YYYY are same\n" +
            "YYYY: Year ( 2020 )\n" +
            "zzz : GMT+05:30\n" +
            "aa : ( AM / PM )"
    
    fun convertToDate(date: String){
	/*
		change expiry string  date to a target date format
	*/
        val sourceFormat = SimpleDateFormat("EEE dd MMM yyy HH:mm:ss zzz", Locale.getDefault())
        val convertedDate = sourceFormat.parse(date)
	val targetFormat = SimpleDateFormat("EEE dd MMM yyy HH:mm:ss", Locale.getDefault())
        val formattedDate = targetFormat.format(convertedDate)
	return formattedDate
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
