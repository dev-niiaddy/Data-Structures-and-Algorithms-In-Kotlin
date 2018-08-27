package lists

fun main(args: Array<String>) {

    val employeeList: MutableList<Employee> = arrayListOf()
    employeeList.add(Employee("James", "Hitch Cock", 1))
    employeeList.add(Employee("Rosa", "Diaz", 22))
    employeeList.add(Employee("Raymond", "Holt", 235))
    employeeList.add(Employee("Amy", "Santiago", 442))


    employeeList.forEach { employee ->
        println(employee)
    }
}