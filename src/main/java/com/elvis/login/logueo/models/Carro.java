package com.elvis.login.logueo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    //creamos una variable en el cual inicializamos la lista
    //de productos comprados que va a estar rn el carro
    private List<ItemCarro> items;
    //implementamso el constructor
    public Carro(){
        this.items=new ArrayList<>();
    }

    //implementamos un método para añadir los productos a la
    //lista o al carrito
    public void addItemCarro(ItemCarro itemCarro){
        if(items.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i-> i.equals(itemCarro))
                    .findAny();
            if(optionalItemCarro.isPresent()){
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else{
            this.items.add(itemCarro);
        }
    }
    public List<ItemCarro> getItems(){
        return items;
    }
    public double getTotal(){
        return items.stream().mapToDouble(ItemCarro::getImporte).sum();
    }
}