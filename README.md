# FlyEase – App de Reservas de Vuelo

FlyEase es una aplicación móvil desarrollada con **Jetpack Compose** para Android. Permite a los usuarios ingresar sus datos personales, seleccionar un destino, elegir una fecha de vuelo y visualizar un resumen de la reserva antes de finalizarla.

---

## Funcionalidades

- Ingreso de datos del pasajero (nombre y número de pasaporte).
- Selección de destino desde una lista desplegable.
- Selección de fecha usando un DatePicker.
- Generación de un resumen claro y estructurado de la reserva.
- Navegación intuitiva entre pantallas.

---

## Navegación de Pantallas

1. **PassengerFormScreen**
    - Formulario para ingresar nombre completo y pasaporte.
2. **FlightSelectionScreen**
    - Selección de destino y fecha del vuelo.
3. **ReservationSummaryScreen**
    - Muestra los datos completos de la reserva.

---

## Tecnologías utilizadas

- **Jetpack Compose**: para la UI declarativa.
- **Material 3**: diseño moderno y adaptado.
- **Navigation Compose**: para el manejo de rutas entre pantallas.
- **DatePickerDialog**: selección de fechas.
- **State Management** con `remember` y `mutableStateOf`.

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/dev22sj-learning/electiva4-parcial1.git
```