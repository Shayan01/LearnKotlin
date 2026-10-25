import com.github.mfathi91.time.PersianDate
import java.time.LocalDate

fun main(args: Array<String>) {
    println("========================= ثبت اطلاعات =========================")
    println("در هر مرحله با وارد کردن عدد ۰ میتوانید از برنامه خارج شوید")
    println("==============================================================")
    var skills: Array<String> = Array<String>(3) { "" }
    var favoriteNames: ArrayList<String> = ArrayList<String>()
    var mobileNumbers: HashMap<String, String> = HashMap<String, String>()
    var CanExecute: Boolean = true
    var ageStatus: String = "تعریف نشده"
    while (CanExecute) {
        print("نام خود را وارد کنید : ")
        var name: String = readln()
        if (name == "0") {
            CanExecute = false
            continue
        }
        print("نام خانوادگی خود را وارد کنید : ")
        var family: String = readln()
        if (family == "0") {
            CanExecute = false
            continue
        }
        print("سال تولد خود را به شمسی یا میلادی وارد کنید : ")
        var dateOfBirth: Int = readln().toInt()
        if (dateOfBirth == 0) {
            CanExecute = false
            continue
        }
        var currentYear: Int
        if (dateOfBirth < 1880) {
            currentYear = PersianDate.now().year
        } else {
            currentYear = LocalDate.now().year
        }
        var age: Int = currentYear - dateOfBirth
        when (age) {
            in 1..5 -> ageStatus = "نوزاد"
            in 6..9 -> ageStatus = "کودک"
            in 10..18 -> ageStatus = "نوجوان"
            in 19..30 -> ageStatus = "جوان"
            in 31..60 -> ageStatus = "میانسال"
            in 60..1000 -> ageStatus = "کهنسال"
            in 60..1000 -> ageStatus = "کهنسال"
            else -> ageStatus = "کهنسال"

        }
        println("شماره تماس ها را وارد کنید")
        for (i in 0..2){
            val index = i +1
            print("$index.")
            mobileNumbers.put(i.toString(),readln())
        }
        println("مهارت را وارد کنید : ")
        for (i in 0..2) {
            val index = i + 1
            print("$index.")
            skills[i] = readln()
            if (skills[i] == "0") {
                skills[i] = ""
                break
            }
        }
        println("نام های مورد علاقه خود را وارد کنید")
        for (i in 0..2) {
            val index = i +1
            print("$index.")
            favoriteNames.add(readln())
        }
        println("==================== نمایش مشخصات =========================")
        println("نام :  " + name)
        println("نام خانوادگی :  " + family)
        println("سن :  " + age + " سال - $ageStatus")
        println("مهارت ها")
        for (skill in skills) {
            if (skill.length > 0)
                println(skill)
        }
        println("نام های مورد علاقه")
        for (favoritename in favoriteNames){
          println(favoritename)
        }
        println("شماره تماس ها")
        for (key in mobileNumbers.keys){
            println(mobileNumbers[key])
        }
        println("===========================================================")
        println("\n\n\n\n")
    }
}