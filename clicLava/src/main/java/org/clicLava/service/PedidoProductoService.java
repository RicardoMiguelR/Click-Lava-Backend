package org.clicLava.service;

import org.clicLava.model.PedidoProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoProductoService {

    private final List<PedidoProducto> lista = new ArrayList<>();

    public PedidoProductoService() {
        lista.add(new PedidoProducto(1L, 1L, 1, 89.99));
        lista.add(new PedidoProducto(1L, 3L, 2, 19.90));
        lista.add(new PedidoProducto(2L, 2L, 1, 58.79));
        lista.add(new PedidoProducto(2L, 5L, 1, 21.80));
    }

    public List<PedidoProducto> getAll() {
        return lista;
    }

    public PedidoProducto getOne(Long idPedido) {
        for (PedidoProducto pp : lista) {
            if (pp.getIdPedido().equals(idPedido)) {
                return pp;
            }
        }
        return null;
    }

    public PedidoProducto add(PedidoProducto nuevo) {
        System.out.println("Agregando: " + nuevo.getIdPedido() + ", " + nuevo.getIdProducto() + ", " + nuevo.getCantidad() + ", " + nuevo.getPrecioUnitario());
        lista.add(nuevo);
        return nuevo;
    }

    public PedidoProducto delete(Long idPedido) {
        PedidoProducto encontrado = getOne(idPedido);
        if (encontrado != null) {
            lista.remove(encontrado);
        }
        return encontrado;
    }

    public PedidoProducto update(Long idPedido, Integer cantidad, Double precioUnitario) {
        PedidoProducto existente = getOne(idPedido);
        if (existente != null) {
            if (cantidad != null) {
                existente.setCantidad(cantidad);
            }
            if (precioUnitario != null) {
                existente.setPrecioUnitario(precioUnitario);
            }
        }
        return existente;
    }
}
