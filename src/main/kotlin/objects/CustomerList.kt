package objects
import java.io.Serializable

class CustomerList: Serializable{
    private var customerList: ArrayList<Customer> = ArrayList()

    init{
        customerList.add(Customer("Nick Scali", "nickscali@gmail.com", "0433339999"))
        customerList.add(Customer("David Jones", "davidjones@gmail.com", "0422345678"))
        customerList.add(Customer("Alan Berlini", "alanberlini@gmail.com", "0433286547"))
        customerList.add(Customer("Scott Johnson", "scottjohnson@gmail.com", "0462896547"))
        customerList.add(Customer("David Nicer", "nicerdavid@gmail.com", "0412588935"))
        customerList.add(Customer("James Cook", "jamescook@gmail.com", "0488524631"))
        customerList.add(Customer("Zander Cute", "zandercute@gmail.com", "0466885741"))
        customerList.add(Customer("Ryan Choong", "ryanchoong@gmail.com", "0497256615"))

    }

    fun sortName() {
        customerList.sortWith(compareBy<Customer> { it.name }.thenBy { it.email }.thenBy { it.mobile })
    }

    fun addCustomer() {
        println("Please enter the Name of Customer:")
        val customerName = readln()
        println("Please enter the Email of Customer:")
        val customerEmail = readln()
        println("Please enter the Mobile of Customer:")
        val customerMobile = readln()

        customerList.add(Customer(customerName, customerEmail, customerMobile))
    }

    fun searchCustomer(target: String, selection: Int): CustomerList {
        val filterList = CustomerList()
        filterList.clearList()

        when(selection){
            1 -> {
                customerList.forEach {
                    if (it.name.contains(target, ignoreCase = true)) {
                        filterList.customerList.add(it)
                    }
                }
            }
            2 -> {
                customerList.forEach {
                    if (it.email.contains(target, ignoreCase = true)) {
                        filterList.customerList.add(it)
                    }
                }
            }
            3 -> {
                customerList.forEach {
                    if (it.mobile.contains(target, ignoreCase = true)) {
                        filterList.customerList.add(it)
                    }
                }
            }
            else -> {
                println("Invalid input. Please select correct option!")
            }
        }
        return filterList
    }

    fun displayCustomer() {
        customerList.forEach{ it.display()}
    }

    fun clearList() {
        this.customerList.clear()
    }

}
