package model;

public class RepartidorMoto extends Repartidor {
    private String marcaModelo;
    private String color;
    private int cilindraje;

    public RepartidorMoto(String id, String nombre, String marcaModelo, String color, int cilindraje){
        super(id, nombre);
        this.marcaModelo = marcaModelo;
        this.color = color;
        this.cilindraje = cilindraje;
    }
@Override
    public void asignarPedido(String idPedido){
        System.out.println("Asignando el pedido" + idPedido + " a la motocicleta" + marcaModelo + "color" + color  + "(" + cilindraje + "cc).");
        this.setDisponible(false);
}

public String getMarcaModelo(){
        return marcaModelo;
}
public void setMarcaModelo(String marcaModelo){
        this.marcaModelo = marcaModelo;
}
public String getColor(){
        return color;
}
public void setColor(String color){
        this.color = color;
}
public int getCilindraje(){
        return cilindraje;
}
public void setCilindraje(int cilindraje){
        this.cilindraje = cilindraje;
}







}