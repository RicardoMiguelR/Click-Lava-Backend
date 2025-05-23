package org.clicLava.service;

import java.util.List;
import org.clicLava.model.PedidoProducto;
import org.clicLava.repository.PedidoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProductoService {

    private final PedidoProductoRepository pedidoProductoRepository;

    @Autowired
    public PedidoProductoService(PedidoProductoRepository pedidoProductoRepository) {
        this.pedidoProductoRepository = pedidoProductoRepository;
    }

    public List<PedidoProducto> getPedidos() {
        return pedidoProductoRepository.findAll();
    }

    public PedidoProducto getPedido(Long idPedido) {
        return pedidoProductoRepository.findById(idPedido).orElseThrow(
            () -> new IllegalArgumentException("El pedido con ID [" + idPedido + "] no existe.")
        );
    }

    public PedidoProducto deletePedido(Long idPedido) {
        PedidoProducto tmp = null;
        if (pedidoProductoRepository.existsById(idPedido)) {
            tmp = pedidoProductoRepository.findById(idPedido).get();
            pedidoProductoRepository.deleteById(idPedido);
        }
        return tmp;
    }

    public PedidoProducto addPedido(PedidoProducto pedido) {
        pedidoProductoRepository.save(pedido);
        return pedido;
    }

    public PedidoProducto updatePedido(Long idPedido, Integer cantidad, Double precioUnitario) {
        PedidoProducto tmp = null;
        if (pedidoProductoRepository.existsById(idPedido)) {
            PedidoProducto pedido = pedidoProductoRepository.findById(idPedido).get();
            if (cantidad != null) pedido.setCantidad(cantidad);
            if (precioUnitario != null) pedido.setPrecioUnitario(precioUnitario);
            pedidoProductoRepository.save(pedido);
            tmp = pedido;
        }
        return tmp;
    }
}
