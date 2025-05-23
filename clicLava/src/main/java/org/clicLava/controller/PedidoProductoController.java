package org.clicLava.controller;

import org.clicLava.model.PedidoProducto;
import org.clicLava.service.PedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/pedidoproducto/")
public class PedidoProductoController {

    private final PedidoProductoService ppService;

    @Autowired
    public PedidoProductoController(PedidoProductoService ppService) {
        this.ppService = ppService;
    }

    @GetMapping
    public List<PedidoProducto> getTodos() {
        return ppService.getPedidos();
    }

    @GetMapping(path="{id}")
    public PedidoProducto getUno(@PathVariable("id") Long idPedido) {
        return ppService.getPedido(idPedido);
    }

    @PostMapping
    public PedidoProducto agregar(@RequestBody PedidoProducto nuevo) {
        return ppService.addPedido(nuevo);
    }

    @DeleteMapping(path="{id}")
    public PedidoProducto eliminar(@PathVariable("id") Long idPedido) {
        return ppService.deletePedido(idPedido);
    }

    @PutMapping(path="{id}")
    public PedidoProducto actualizar(
        @PathVariable("id") Long idPedido,
        @RequestParam(required = false) Integer cantidad,
        @RequestParam(required = false) Double precioUnitario
    ) {
        return ppService.updatePedido(idPedido, cantidad, precioUnitario);
    }
}
