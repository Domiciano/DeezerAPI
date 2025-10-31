# Taller 5 · 19% de Implementación

Debe implementar una tablero de medición IoT. 
Cada estudiante: `robledo`, `mayor`, `mosquera`, `barbosa`, `garcia` y `rengifo` tiene una planta a la que se le está midiendo el Voltaje y la Corriente.

Usted verá en pantalla el estado de su sensor, el objetivo es que usted:

1. Encienda el sistema de medición

2. Una vez encendido, el sistema de medición comienza a enviar datos a un topic específico.

3. Debe almacenar las muestras recibidas en el almacen de datos

4. Debe poder apagar el sistema de medición.

[15%]
Envío de comando de activación (ON)

Cree una interfaz HTML tipo tablero donde por medio de un botón `ON` encienda el sistema de medición
Para hacerlo debe enviar el siguiente mensaje
```json
{ "action": "ON", "deviceId": "robledo" }
```
al topic `icesi/sensors/control` usando MQTT.

[15%]
Envío de comando de apagado (OFF)

Cada tarjeta debe tener también un botón “OFF”, el cual publicará el mensaje:
```json
{ "action": "OFF", "deviceId": "robledo" }
```
Este comando detiene el flujo de datos del estudiante correspondiente.
El cambio de estado debe reflejarse visualmente en el tablero 

[40%]
Visualización de datos en tiempo real

El tablero debe mostrar en cada tarjeta los valores más recientes de voltaje y corriente del estudiante, actualizados en tiempo real.
Los datos son publicados cada segundo por el script principal hacia el tópico del estudiante (icesi/sensors/{deviceId}).

[30%]
Almacenamiento de datos (POST)

Implemente una solicitud POST que permita almacenar los datos de voltaje y corriente generados, incluyendo el nombre del estudiante.

Cada vez que el tablero reciba un nuevo dato, debe enviarlo al endpoint correspondiente mediante fetch, en formato JSON:
```json
{
  "deviceId": "robledo",
  "voltaje": 121.3,
  "corriente": 6.2,
  "timestamp": "2025-10-30T16:12:00Z"
}
```

La conexión es al broker público:

host: broker.emqx.io
port: 8083
user: icesidomicianorincon123123
