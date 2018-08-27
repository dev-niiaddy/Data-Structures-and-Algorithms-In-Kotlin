package lists

class Employee(var firstName: String,
               var lastName: String,
               var id: Int) {


    override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + id
        return result
    }

}