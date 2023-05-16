package objects
import java.io.Serializable

class Customer(var name: String, var email: String, var mobile: String) : Serializable {
    private var id: Int = nextID()

    companion object {
        private var latestId = 30066000

        private fun nextID(): Int {
            latestId++
            return latestId
        }
    }

    fun display() {
        println("ID: $id \t Name: $name")
        println("\tEmail: $email")
        println("\tMobile: $mobile \n")
    }


}