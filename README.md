# pago-linea
## rutas
### Agregar
http://localhost:8080/order/add

body

    {
        "id": 8,
        "name": "Laura",
        "cc": 321,
        "address": "11# 14-08",
        "totalPrice": 85000,
        "items": [
            {
                "id": 1,
                "name": "shoes ",
                "price": 15000,
                "quantity": 1
            },
            {
                "id": 2,
                "name": "jean",
                "price": 20000,
                "quantity": 1
            },
            {
                "id": 3,
                "name": "T-shirt",
                "price": 50000,
                "quantity": 1
            }
        ]
    }
### Consultar todas las ordenes
metodo post
http://localhost:8080/order/getAll

metodo get
### Consultar orden por el id
http://localhost:8080/order/getId/{id} //sin los corchetes

metodo get
### Consultar todas las ordenes que tenga una persona
http://localhost:8080/order/getCc/{cc} //sin los corchetes

metodo delete
### Eliminar una order por el id
http://localhost:8080/order/delete/{id} //sin los corchetes


### modificar una orden
http://localhost:8080/order/update/{cc}/{id} //sin los corchetes
para modificar una orden es necesario la cedula del cliente y el numero de orden para verificar que si sea una orden del cliente, ademas se necesita un body mandando lo sigueinte 
body

    {
        "id": 8,
        "name": "Laura",
        "cc": 321,
        "address": "11# 14-08",
        "totalPrice": 145000,
        "items": [
            {
                "id": 1,
                "name": "shoes ",
                "price": 15000,
                "quantity": 1
            },
            {
                "id": 2,
                "name": "jean",
                "price": 20000,
                "quantity": 2
            },
            {
                "id": 3,
                "name": "T-shirt",
                "price": 50000,
                "quantity": 2
            },
            {
                "id": 5,
                "name": "hat",
                "price": 20000,
                "quantity": 3
            }
        ]
    }
    
    es la misma informacion que al crearla pero pero con los datos nuevos que quiere en la orden.
    el total price no importa que lo manden bien ya que en el codigo se valida y se reasignan los totales.
