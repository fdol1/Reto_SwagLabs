#language: es

Característica: Agregar productos al carrito de compras y validar su titulo de producto
  y precio en el carrito

  Antecedentes:
    Dado que fer ingresa a la pagina de Swaglabas
    Y que fer ingresa sus credenciales
      | usuario       | clave        |
      | standard_user | secret_sauce |

  @RutaCritica
    @AgregarAlCarrito
  Esquema del escenario: : Agregar un producto al carrito de manera exitosa
    Dado que fer selecciona el producto a comprar
      | producto   | precio   |
      | <producto> | <precio> |
    Cuando se dirige al carrito y comprueba su producto
    Entonces verifica el titulo y precio del producto agregado al carrito
    Ejemplos:
      | producto              | precio |
      | Sauce Labs Bike Light | $9.99  |

  @RutaCritica
    @OrdenarPrecioPorLogica
  Esquema del escenario: Se realiza el ordenamiento de los precios, Sin usar los filtros de la pagina (Ordenamiento de burbuja)
    Dado que fer ordena los productos de menor a mayor
      | orden   |
      | <orden> |
    Cuando selecciona el producto indicado por el precio
    Entonces verifica el titulo y precio del producto agregado al carrito
    Ejemplos:
      | orden       |
      | menor_mayor |
      | mayor_menor |

  @RutaCritica
    @AgregarProductoPor
  Esquema del escenario: Se realiza el ordenamiento de los precios, Usando los filtros de la pagina
    Dado que fer ordena la lista
      | orden   |
      | <orden> |
    Cuando agrega agrega al carrito el producto
    Entonces verifica el titulo y precio del producto agregado al carrito
    Ejemplos:
      | orden               |
      | Price (low to high) |
      | Price (high to low) |