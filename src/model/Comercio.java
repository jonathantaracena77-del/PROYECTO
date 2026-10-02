package model;

import interfaces.Calificable;
import java.util.ArrayList;
import java.util.List;

public class Comercio implements Calificable{
    private String id;
    private String nombre;
    private boolean disponible;
    private List<Integer> calificaciones;

    public Comercio(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.disponible = true;
        this.calificaciones = new ArrayList<>();
    }

    public void aceptarPedido(Pedido p){
        if (this.disponible){
            System.out.println("Comercio '" + this.nombre + "' ha ACEPTADO el pedido " + p.getId());
            p.avanzarEstado(EstadoPedido.CONFIRMADO);
        }else{
            System.out.println("Comercio cerrado. El pedido" + p.getId() + "sera rechazado.");
            this.rechazarPedido(p);
        }
    }
    public void rechazarPedido(Pedido p){
        p.avanzarEstado(EstadoPedido.RECHAZADO);
    }
    public void marcarEnPreparacion(Pedido p){
        System.out.println("Comercio '" + this.nombre + "' está preparando el pedido " + p.getId());
        p.avanzarEstado(EstadoPedido.EN_PREPARACION);
    }
    public void marcarComoListo(Pedido p){
        System.out.println("El pedido " + p.getId() + " está LISTO para ser recogido.");
        p.avanzarEstado(EstadoPedido.LISTO);
    }

    @Override
    public void agregarCalificacion(int punteo){
        this.calificaciones.add(punteo);
    }

    @Override
    public double obtenerPromedio(){
        if (calificaciones.isEmpty()) return 0.0;
        int suma = 0;
        for (int nota : calificaciones){
            suma += nota;
        }
        return (double) suma / calificaciones.size();
    }

    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public boolean isDisponible(){return disponible;}
    public void setDisponible(boolean disponible){this.disponible= disponible; }






}


