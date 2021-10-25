# new feature
# Tags: optional

Feature: Inicio de sesion
  como un usuario de sistema
  necesito que validar el logueo y disposibilidad del sitio web
  para poder tener seguridad en el perfil y la pagina

  Scenario: Login exitoso
    Given el usuario esta en el recurso adecuado y con el usuario y la contraseña
    When cuando el usuario presiona el boton login
    Then  el sistema permitira loguear al usuario de manera exitosa dirigiendolo hacia el home de la pagina
