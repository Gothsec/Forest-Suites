/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package modelo;


public class ModeloLogin {
    String usuario, contrasena;
    
    public ModeloLogin(){
        usuario = "admin";
        contrasena = "123";
    }

    public boolean verificar(String ingresar_usuario, String ingresar_contrasena) {
        return usuario.equals(ingresar_usuario) && contrasena.equals(ingresar_contrasena);
    }
}

