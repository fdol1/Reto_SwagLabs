#language: es

Característica: Se realiza una compra de principio a fin

  Antecedentes:
    Dado que fer ingresa a la pagina de Swaglabas
    Y que fer ingresa sus credenciales
      | usuario       | clave        |
      | standard_user | secret_sauce |

  @RutaCritica
    @RealizarCompra
  Esquema del escenario: : Realizar una compra de manera exitosa
    Dado que fer selecciona el producto a comprar
      | producto   | precio   |
      | <producto> | <precio> |
    Cuando se dirige al carrito y comprueba su producto
    E ingresa los datos para la compra
      | nombre1 | nombre2 | codigoPostal |
      | <nombre1> | <nombre2> | <codigoPostal> |
    Entonces verifica los precios y finaliza la compra
    Y verifica el mensaje de compra exitosa: Thank you for your order!
    Ejemplos:
      | producto              | precio | nombre1 | nombre2 | codigoPostal |
      | Sauce Labs Bike Light | $9.99  | luis    | fer     | 050001       |

