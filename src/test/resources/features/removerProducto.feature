#language: es

Característica: Remover un producto del carrito de compras

  Antecedentes:
    Dado que fer ingresa a la pagina de Swaglabas
    Y que fer ingresa sus credenciales
      | usuario       | clave        |
      | standard_user | secret_sauce |

  @RutaCritica
    @RemoverDelCarrito
  Esquema del escenario: : Remover producto del carrito de manera exitosa
    Dado que fer selecciona el producto a comprar
      | producto   | precio   |
      | <producto> | <precio> |
    Cuando se dirige al carrito a remover su producto
    Ejemplos:
      | producto              | precio |
      | Sauce Labs Bike Light | $9.99  |

