import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el numero de la moneda de StarWars que quiere consultar");
        int opcion = 0;
        double cantidadParaConvertir = 0;

        System.out.println("""
                *****************************************
                Bienvenido(a) al conversor de monedas
                
                Seleccione la moneda que desea convertir:
                1- Peso Mexicano (MXN) a Peso Dominicano (DOP)
                2- Dolar (USD) a Peso Dominicao (DOP)
                3- Peso Colombiano (COP) a Peso Dominicano (DOP)
                4- Peso Argentino (ARS) a Peso Dominicano (DOP)
                5- Peso Chileno (ClP) a Peso Dominicano (DOP)
                8- Salir
                *****************************************
                """);

        while (true){
            System.out.println("Elija una opción: ");
            opcion = lectura.nextInt();

            if(opcion == 8){
                break;
            }else{

            }
            switch (opcion){
                case 1:
                    Calculos("MXN", "DOP", PedirCantidadAConvertir(cantidadParaConvertir));
                    break;
                case 2:
                    Calculos("USD", "DOP", PedirCantidadAConvertir(cantidadParaConvertir));
                    break;
                case 3:
                    Calculos("COP", "DOP", PedirCantidadAConvertir(cantidadParaConvertir));
                    break;
                case 4:
                    Calculos("ARS", "DOP", PedirCantidadAConvertir(cantidadParaConvertir));
                    break;
                case 5:
                    Calculos("CLP", "DOP", PedirCantidadAConvertir(cantidadParaConvertir));
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opcion incorrecta, seleccione de nuevo");
            }
        }
    }

    public static void Calculos(String codigoBase, String codigoObjetivo, double cantidadConversion){
        ConexionAPI consulta = new ConexionAPI();

        String resultado = consulta.ConvierteMonedas("USD", "DOP", cantidadConversion);
        System.out.println("\nEl valor: " + cantidadConversion
                + " (" + codigoBase + "), equivale a: "
                + resultado + " (" + codigoObjetivo + ")" +
                "\n\n *****************************************\n");
    }

    public static double PedirCantidadAConvertir(double cantidad){
        Scanner lectura = new Scanner(System.in);
        System.out.println("\nElija una cantidad a convertir: ");
        try{
            cantidad = Double.parseDouble(lectura.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Error, debe digitar un numero.");
        }
        return cantidad;
    }

}
