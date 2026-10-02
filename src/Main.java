
    import exception.EstadoPedidoInvalidoException;
    import model.EstadoPedido;
    import model.Pedido;

    public class Main{
        public static void main(String [] args){
            System.out.println("--- INICIANDO PRUEBA DE PEDIDO---");
            Pedido miPedido = new Pedido("PED-001");

            try{
                miPedido.avanzarEstado(EstadoPedido.CONFIRMADO);
                miPedido.avanzarEstado(EstadoPedido.EN_PREPARACION);
                miPedido.avanzarEstado(EstadoPedido.LISTO);
                miPedido.avanzarEstado(EstadoPedido.EN_CAMINO);
                miPedido.avanzarEstado(EstadoPedido.ENTREGADO);

                System.out.println(" INTENTANDO ROMPER LA REGLA");
                 miPedido.avanzarEstado(EstadoPedido.CREADO);

            } catch (EstadoPedidoInvalidoException e){
                System.err.println("EXCEPCION CAPTURADA" + e.getMessage());
            }
        }
    }






































