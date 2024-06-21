package ar.com.codo24100.oop;

public class MainBuscador {
    public static void main(String[] args) {

        //Esto es para una prueba en 'Memoria', de aki nace la busqueda!!
        //Se le llama HARD CODEADO, y es la frase 'iron man' en el campo input de HTML
        String claveQueEnviaElUsuarioPorForm = "iron man";
        
        //instancio mi buscador
        Buscador buscador = new Buscador();

        buscador.setClaveDeBusqueda(claveQueEnviaElUsuarioPorForm);

        buscador.buscar();

        buscador.mostrarResultados();

        /*
         * intrerfaces > mysql 
         * controller 
         */
    }
}
