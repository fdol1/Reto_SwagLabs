#language: es

Característica: Se realiza inicio de sesion exitoso y agunas pruebas de errores

  Antecedentes:
    Dado que fer ingresa a la pagina de Swaglabas

  @RutaCritica
    @IniciarSesion
  Esquema del escenario: Realizar inicio de sesion
    Dado que fer ingresa sus credenciales
      | usuario   | clave   |
      | <usuario> | <clave> |
    Entonces Entonces verifica el titulo Swag Labs
    Ejemplos:
      | usuario       | clave        |
      | standard_user | secret_sauce |


  @RutaCritica
    @IniciarSesionDatosErrados
  Esquema del escenario: Realizar inicio de sesion con datos errados
    Dado que fer ingresa sus credenciales
      | usuario   | clave   |
      | <usuario> | <clave> |
    Entonces Entonces verifica mensaje error Epic sadface: Username and password do not match any user in this service
    Ejemplos:
      | usuario          | clave          |
      | standard_user    | clave_invalida |
      | usuario_invalido | secret_sauce   |


  @RutaCritica
    @UsuarioBloqueado
  Esquema del escenario: Realizar inicio de sesion, con usuario bloqueado
    Dado que fer ingresa sus credenciales
      | usuario   | clave   |
      | <usuario> | <clave> |
    Entonces Entonces verifica mensaje error Epic sadface: Sorry, this user has been locked out.
    Ejemplos:
      | usuario         | clave        |
      | locked_out_user | secret_sauce |