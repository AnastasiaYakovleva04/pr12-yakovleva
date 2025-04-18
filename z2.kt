import kotlinx.coroutines.*

fun main()= runBlocking<Unit>{
    try {
        val list: MutableList<User> = mutableListOf()
        while (true) {
            println("Меню:")
            println("1.Загрузить участников")
            println("2.Блокировка")
            val act = readln().toInt()
            when(act){
                1 -> {
                    print("Введите количество пользователей: ")
                    val n = readln().toInt()
                    if (n < 1)
                        println("Значения менее 1 не могут быть приняты")
                    else {
                        for (i in 1..n) {
                            println(i)
                            println("Введите имя пользователя")
                            val name = readln()
                            println("Введите пароль")
                            val password = readln()
                            println("Введите количество репозиториев")
                            val qRep = readln().toUInt()
                            val user = User(name, password, qRep)
                            list.add(i - 1, user)
                        }
                    }
                }
                2 -> runBlocking {
                    val sortedUserLust = list.sortedBy { it.qRep }
                    println("Подождите, идет сортировка...")
                    println()
                    launch {
                        delay(5000L)
                        sortedUserLust.forEach {
                            println("Имя: ${it.name}, Количество репозиториев: ${it.qRep}")
                        }
                    }
                }
                else -> break
            }
        }
    }
   catch(e: Exception) {
       println("Неверный формат данных")
   }
}
