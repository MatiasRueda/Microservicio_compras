# Microservicios compras

![Static Badge](https://img.shields.io/badge/Estado%20-%20Terminado%20-%20green)


## Introducción
Proyecto personal creado para mostrar mis conocimientos sobre Java y Spring.
Lo que se busca con este proyecto es crear distintos microserivicios que se comunican
entre si para poder formar un server de reservas.
Para poder acceder a la configuracion que utiliza este proyecto dirigirse al siguiente
repositorio: 
<a href="https://github.com/MatiasRueda/Microservicio_reservas_configuracion">Configuracion</a>

## Tipo de proyecto
Proyecto individual

## Tecnologías usadas
- Java
- Spring Cloud Config
- Spring Cloud Gateway
- Spring Cloud Netflix
- Spring Cloud Circuit Breaker
- Maven
- MySQL

## Instalación 
Para poder usar el proyecto es necesario tener instalado Java.

## Uso
Para poder usar el servidor de manera local, corra los archivos en el siguiente orden:
- configuración servidor
- discovery servicio
- api
- reserva microservicio
- stock microservicio
- producto microservicio

## Peticiones
### GET
#### Producto
Para poder obtener los productos guardados en la base de datos
```
http://localhost:8080/api/productos
```
Esto devuelve una lista de productos disponibles para reservar

### POST

#### Producto
Para poder guardar un producto en la base de datos de producto:
Hay que enviar el siguiente RequestBody 
```
{
  "nombre": "Marcador",
  "precio": 20,
  "stock": 75
}
```
_El anterior RequestBody es solo un ejemplo, puede cambiarle el nombre y agregar el producto que quiera_ 

A la siguiente dirección:
```
http://localhost:8080/api/productos
```


En caso de guardarse devuelve el siguiente mensaje:
**Producto guardado**
En caso de que el microservicio stock tenga algún problema, devolverá el siguiente mensaje:
**El microservicio Stock esta desconectado**

<br>

#### Reserva
Para poder guardar una reserva en la base de datos de reserva:
Hay que enviar el siguiente RequestBody 
```
{
  "reservaItems": [
    {
      "nombre": "Lapicera",
      "precio": 50
    }  
  ]
}
```
_El anterior RequestBody es solo un ejemplo, puede cambiarle el nombre, precio y reservar lo que quiera_ 

A la siguiente dirección:
```
http://localhost:8080/api/reserva/guardar
```
En caso de reservarse devuelve el siguiente mensaje:
**Guardado**

En caso de que no haya stock de algún producto no se reservara y devolverá el siguiente mensaje:
**No se pudo guardar, porque no hay stock**

En caso de que el microservicio stock tenga algún problema, devolverá el siguiente mensaje:
**El microservicio Stock esta desconectado**


> [!NOTE]
> La base de datos a la que esta conectada el servidor es lenta, así que por favor tenga paciencia.
