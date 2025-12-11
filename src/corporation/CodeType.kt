package corporation

enum class CodeType(val title: String) {
    EXIT("Salir"),
    ENTER_PRODUCT("Ingresar producto"),
    SHOW_ALL_ITEMS("Mostrar todos los productos"),
    REMOVE_PRODUCT_CARD("Eliminar tarjeta de producto"),
    REGISTER_NEW_EMPLOYEE("Registrar nuevo empleado"),
    FIRE_EMPLOYEE("Despedir un empleado"),
    SHOW_ALL_EMPLOYEES("Mostrar lista de empleados"),
    CHANGE_SALARY("Cambiar salario"),
    CHANGE_AGE("Cambiar edad")
}