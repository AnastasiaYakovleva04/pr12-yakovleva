import kotlinx.coroutines.*
fun main(args: Array<String>) = runBlocking<Unit>{
    try {
        print("Введите количество функций: ")
        val n = readln().toInt()
        if (n < 1)
            println("Количество не может быть меньше 1")
        else{
            launch {
                for (i in 0..n)
                    println(doCorut(i))
            }
        }
    }
    catch (e:Exception) {
        println("Неверный формат данных")
    }
}

suspend fun doCorut(index: Int): String{
    delay(500L)
    return "$index"
}
