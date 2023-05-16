package objects
import java.io.*

class FileIO {

    fun saveFile(customerList: CustomerList){
        try{
            val fileOut = FileOutputStream("customers.dat")
            val objectOut = ObjectOutputStream(fileOut)
            objectOut.writeObject(customerList)

            fileOut.close()
            println("Saving Completed - customers.dat")
        } catch (e: IOException){
            println(e)
        }
    }

    fun loadFile(): CustomerList {
        var obj = CustomerList()

        try {
            val fileIn = FileInputStream("customers.dat")
            val objectIn = ObjectInputStream(fileIn)
            obj = objectIn.readObject() as CustomerList
            fileIn.close()
        } catch (e: IOException){
            println(e)
        } catch (e: ClassNotFoundException){
            println(e)
        }
        return obj

    }
}

