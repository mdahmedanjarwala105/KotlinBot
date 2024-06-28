interface Coffee {
    fun coffeeType()
    fun sugar()
    fun gaps()
}

interface Temperature {
    fun tempConvert()
}

data class ExtraSleep (var extraHours:  Int)

class Robot(var roboName: String? = null, private var coffeeVal: String? = null, private var sugar: Char? = null, private var gaps: Int? = null,
            private var sugarVal: String? = null, private var randomFood: String? = null): Coffee, Temperature{

    private val days = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val subject = mutableListOf("Maths", "English", "Hindi", "Science", "Social Science")
    private val vegFood = mutableListOf("Paneer-Gravy", "Lady Finger", "Dal-Rice", "Idli-Dosa", "Pumpkin", "Potatoe-Brinjal", "Veg-Shawarma")
    private val nonVegFood = mutableListOf("Chicken Crispy", "Butter Chicken", "Fried-Rice", "Chicken-Gravy", "Chicken-Shawarma", "Chicken-Chilly", "Seekh-Kabab")
    private val difClothes = mutableListOf("Party Clothes", "College Clothes", "Traditional Clothes", "Professional Clothes")

    fun nameRobo() {
        print("Give a name to your robot -> ")
        roboName = readln()
        println("Hello my name is -> $roboName and You can assign me your work to have an easy life.")
    }

    fun roboAwake() {

    }

    fun alarm() {

        print("How many day's of week you want alarm to ring? (Give an Integer value) 'Warning: Only enter a number between 1 - 7 since a week have only 7 day's': ")
        val alarmInp1 = readln()
        val alarmInpInt1 = alarmInp1.toInt()
        if (alarmInpInt1 in 1..7){
            print("What time do you want $roboName to wake you up? (Give an Integer value): ")
            val alarmInp2 = readln()
            val alarmInpInt2 = alarmInp2.toInt()
            println("Alarm set for $alarmInpInt2 O'clock")
            for(i in 0..<alarmInpInt1){
                println("It's ${days[i]} $alarmInp2 O'clock Wake Up!")
            }
        }
        else {
            println("Number is not valid")
        }
    }

    override fun coffeeType() {
        println("Which coffee do you want black or with milk? (for Black -> B for With Milk -> M): ")
        val coffeeType : Char = readln().single().uppercaseChar()
        when (coffeeType) {
            'B' -> {
                coffeeVal = "Black Coffee"
                sugar()
            }
            'M' -> {
                coffeeVal = "Milk Coffee"
                sugar()
            }
            else -> {
                println("Invalid letter!")
            }
        }
    }

    override fun sugar() {
        println("Do you want Coffee with Sugar or without Sugar? (For yes -> y and For no -> n): ")
        sugar = readln().single().uppercaseChar()
        when (sugar) {
            'Y' -> {
                sugarVal = "with Sugar"
                gaps()
            }
            'N' -> {
                sugarVal = "without Sugar"
                gaps()
            }
            else -> {
                println("Invalid letter!")
            }
        }
    }

    override fun gaps() {
        println("For how many days of the week you want $coffeeVal $sugarVal? : ")
        gaps = readln().toInt()
        if(gaps in 1..7){
            for(i in 0..<gaps!!){
                println("It's ${days[i]} and your morning $coffeeVal $sugarVal is ready!!!")
            }
        }
        else {
            println("(Invalid Number) A week have 7 days so type a number between 1 to 7.")
        }
    }

    fun heatWater() {

        println("Do you take bath everyday or is there any exception to it? (For yes -> y or For no -> n): ")
        val bath = readln().single().uppercaseChar()
        when (bath) {
            'N' -> {
                tempConvert()
            }
            'Y' -> {
                println("Which day do you want to skip for bathing? : ")
                val noBath = readln().uppercase()
                when(noBath) {
                    "MONDAY" -> {
                        days.removeAt(0)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "TUESDAY" -> {
                        days.removeAt(1)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "WEDNESDAY" -> {
                        days.removeAt(2)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "THURSDAY" -> {
                        days.removeAt(3)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "FRIDAY" -> {
                        days.removeAt(4)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "SATURDAY" -> {
                        days.removeAt(5)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    "SUNDAY" -> {
                        days.removeAt(6)
                        println("You are going to take baths on $days")
                        tempConvert()
                    }
                    else -> println("Do enter a valid day!")
                }
            }
            else -> println("Enter valid Letter!")
        }
    }

    override fun tempConvert() {
        println("It's the time for bath would you like to write temperature in degree celsius or degree fahrenheit? \n" +
                "(For entering temperature in celsius -> C or For entering temperature in fahrenheit -> F): ")
        val temp = readln().single().uppercaseChar()
        when (temp) {
            'C' -> {
                println("Enter the temperature in celsius: ")

                val celsius = readln().toFloat()
                val fahrenheit = celsius * (9/5) +32

                println("Your temperature is set to $celsius degree celsius that is $fahrenheit degree fahrenheit for $days.\n.")
            }
            'F' -> {
                println("Enter the temperature in fahrenheit: ")

                val fahrenheit = readln().toFloat()
                val celsius = 5/9 * (fahrenheit - 32)

                println("Your temperature is set to $fahrenheit degree fahrenheit that is $celsius degree celsius for $days.\n")
            }
            else -> println("Enter valid degree!")
        }
    }

    fun timeTable() {
        for ( i in 0..4) {
            println("It's ${days[i]} and your Time-Table is ${subject.shuffled()}")
        }
        println("Do you have full day or half day on Saturdays? (For Full day enter -> F and For Half day enter -> H): ")
        val halfFull = readln().single().uppercaseChar()
        when (halfFull) {
            'F' -> {
                println("It's Saturday and your Time-Table is ${subject.shuffled()}\n")
            }
            'H' -> {
                println("It's Saturday and your Time-Table is${subject.shuffled().take(3)}\n")
            }
            else -> println("Enter valid Letter!")
        }
    }

    fun food() {
        println("Are you feeling Hungry? (For yes enter -> Y and For no enter -> N)")
        val hungry = readln().single().uppercaseChar()
        if(hungry == 'Y') {
            println("Are you Vegan or a non-vegetarian?")
            val eatHabit = readln().uppercase()
            when (eatHabit) {
                "NON-VEGETARIAN" -> {
                    randomFood = nonVegFood.random()
                    println("Your $randomFood is ready!!!")
                }
                "VEGAN", "VEGETARIAN" -> {
                    randomFood = vegFood.random()
                    println("Your $randomFood is ready!!!")
                }
                else -> {
                    println("You Entered Something Invalid!!!")
                }
            }
        }
    }

    fun clothes() {
        println("What clothes will you prefer to wear today? (For Party Type clothes enter -> P or For College Type clothes enter -> C " +
                "or For Traditional Type clothes enter -> T or For Professional Type clothes enter -> PC")

        val clothes = readln().uppercase()
        when (clothes) {
            "P" -> println("Your ${difClothes[0]} will be ready till the time you take bath.")
            "C" -> println("Your ${difClothes[1]} will be ready till the time you take bath.")
            "T" -> println("Your ${difClothes[2]} will be ready till the time you take bath.")
            "PC" -> println("Your ${difClothes[3]} will be ready till the time you take bath.")
            else -> println("Type Appropriate Letter!")
        }
    }
}

fun main() {
    val robot = Robot()
    robot.nameRobo()
    robot.alarm()
    robot.coffeeType()
    robot.clothes()
    robot.heatWater()
    robot.timeTable()
    robot.food()
    val extraSleep = ExtraSleep(2)
    println("Since you have assigned your tasks to ${robot.roboName} now you can have extra hours of sleep for ${extraSleep.extraHours} Hours.")
}