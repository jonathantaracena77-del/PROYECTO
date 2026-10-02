package model;

import exception.EstadoPedidoInvalidoException;

public class Pedido{
    private String id;
    private EstadoPedido estadoActual;

    public Pedido(String id){
        this.id = id;
        this.estadoActual =EstadoPedido.CREADO;
    }

    public void avanzarEstado(EstadoPedido nuevoEstado){
        if (!esTransicionValida(this.estadoActual, nuevoEstado)){
            throw new EstadoPedidoInvalidoException(
                    "Transicion invalida: No se puede pasar de" + this.estadoActual + "a" + nuevoEstado
            );
        }
        this.estadoActual = nuevoEstado;
        System.out.println("El pedido" + this.id +"ahora esta en estado:" + this.estadoActual);
    }

    private boolean esTransicionValida(EstadoPedido actual, EstadoPedido nuevo){
        if (actual == EstadoPedido.ENTREGADO || actual == EstadoPedido.CANCELADO || actual == EstadoPedido.RECHAZADO){
            return false;
        }

        switch (actual){
            case CREADO:
                return nuevo == EstadoPedido.CONFIRMADO || nuevo == EstadoPedido.RECHAZADO || nuevo == EstadoPedido.CANCELADO;
            case CONFIRMADO:
                return nuevo == EstadoPedido.EN_PREPARACION || nuevo == EstadoPedido.CANCELADO;
            case EN_PREPARACION:
                return nuevo == EstadoPedido.LISTO;
            case LISTO:
                return nuevo == EstadoPedido.EN_CAMINO;
            case EN_CAMINO:
                return nuevo == EstadoPedido.ENTREGADO;
            default:
                return false;
        }
    }

    public String getId(){
        return id;
    }

    public EstadoPedido getEstadoActual(){
        return estadoActual;
    }

}