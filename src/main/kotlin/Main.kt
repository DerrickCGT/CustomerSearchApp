import objects.*
import java.lang.NumberFormatException

/*
Name: Derrick Choong
Student ID: 30066568
Program Description: The program is developed for SMT Business Customer Search App
 */

fun main(args: Array<String>) {


    var isOn = true
    var listOfCustomers = CustomerList()
    val fileInputOutput = FileIO()

    while (isOn) {
        println(
            """
            
            SMT Customer Search Program
            1. Display all customers
            2. Sort Customer List by Name
            3. Search Customer
            4. Save File
            5. Load File
            6. Exit
            Please select the option:
        """.trimIndent()
        )
        try {
            when (readln().toInt()) {
                1 -> {
                    println()
                    listOfCustomers.displayCustomer()
                }

                2 -> {
                    listOfCustomers.sortName()
                }

                3 -> {
                    var searchSelection = 0

                    while (searchSelection.toInt() !in 1..3) {
                        println(
                            """
                    
                    Search option available as below
                    1. Search Customer by Name
                    2. Search Customer by Email
                    3. Search Customer by Mobile
                    Please input the option:
                """.trimIndent()
                        )
                        try {
                            searchSelection = readln().toInt()
                        } catch (e: NumberFormatException) {
                            println("Invalid input. Please select correct option!")
                        }

                    }


                    println("Please input the search term")
                    val userInput = readln()

                    val resultList = listOfCustomers.searchCustomer(userInput, searchSelection)
                    resultList.displayCustomer()
                }

                4 -> {
                    fileInputOutput.saveFile(listOfCustomers)
                }

                5 -> {
                    listOfCustomers.clearList()
                    listOfCustomers = fileInputOutput.loadFile()
                }

                6 -> {
                    isOn = false
                }

                else -> {
                    println("Error! Incorrect input of selection.")
                }
            }
        } catch (e: NumberFormatException) {
            println("Please input the correct selection!")
        }
    }

}