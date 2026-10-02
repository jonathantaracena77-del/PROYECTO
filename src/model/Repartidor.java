package model;

import interfaces.Calificable;
import interfaces.Rastreable;
import java.util.ArrayList;
import java.util.List;

public abstract class Repartidor implements Rastreable, Calificable{
    private String id;
    private String nombre;
    private boolean disponible;
    private List<Integer> calificaciones;
    private String ubicacionActual;

    public Repartidor(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.disponible = true;
        this.calificaciones = new ArrayList<>();
        this.ubicacionActual = "0.0, 0.0";

    }

    public abstract void asignarPedido(String idPedido);

    @Override
    public void  agregarCalificacion(int punteo) {
        this.calificaciones.add(punteo);
    }
    @Override
    public double obtenerPromedio(){
        if (calificaciones.isEmpty()) return 0.0;
        int suma = 0;
        for (int nota: calificaciones) {
            suma += nota;
        }
        return (double) suma / calificaciones.size();
    }
    @Override
    public void actualizarUbicacion(double latitud, double longitud){
        this.ubicacionActual = latitud + "," + longitud;
    }
    @Override
    public String obtenerUbicacion() {
        return this.ubicacionActual;
    }

    public String getNombre(){return nombre;}
    public boolean isDisponible(){return disponible;}
    public void setDisponible(boolean disponible){this.disponible = disponible;}

}