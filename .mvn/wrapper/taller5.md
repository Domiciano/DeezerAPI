# Taller 5 · 19% de Implementación

Debe implementar una simulación de sistema de medición IoT para los seis estudiantes: robledo, mayor, mosquera, barbosa, garcia y rengifo.

Este taller combina comunicación en tiempo real por MQTT con interacción en el navegador.
El script principal (sampleControl.js) se ejecutará en el navegador y debe ser capaz de enviar y detener flujos de datos de voltaje y corriente hacia cada estudiante.

[15%]
Envío de comando de activación (ON)

Cree una interfaz HTML tipo tablero donde aparezcan los seis estudiantes.
Cada tarjeta debe tener un botón “ON” que publique el mensaje:
```json
{ "action": "ON", "deviceId": "robledo" }
```
Este mensaje debe publicarse en el tópico icesi/sensors/control usando MQTT.
El script principal recibirá este comando y comenzará a generar los datos de voltaje y corriente en tiempo real para el estudiante indicado.

Nota: cada estudiante tiene su propio identificador (deviceId) y debe recibir sus datos por un tópico con su nombre, por ejemplo icesi/sensors/robledo.

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
