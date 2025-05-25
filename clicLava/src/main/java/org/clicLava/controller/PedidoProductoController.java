package org.clicLava.controller;

import org.clicLava.dto.PedidoProductoDTO;
import org.clicLava.model.PedidoProducto;
import org.clicLava.service.PedidoProductoService;
import org.clicLava.util.DTOConverter;
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
    public List<PedidoProductoDTO> getTodos() {
        List<PedidoProducto> pedidoProductos = ppService.getPedidos();
        return pedidoProductos.stream()
            .map(DTOConverter::convertToDTO)
            .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping(path="{id}")
    public PedidoProductoDTO getUno(@PathVariable("id") Long idPedido) {
        PedidoProducto pedidoProducto = ppService.getPedido(idPedido);
        return DTOConverter.convertToDTO(pedidoProducto);
    }

    @PostMapping
    public PedidoProductoDTO agregar(@RequestBody PedidoProducto nuevo) {
        PedidoProducto pedidoProducto = ppService.addPedido(nuevo);
        return DTOConverter.convertToDTO(pedidoProducto);
    }

    @DeleteMapping(path="{id}")
    public PedidoProductoDTO eliminar(@PathVariable("id") Long idPedido) {
        PedidoProducto pedidoProducto = ppService.deletePedido(idPedido);
        return DTOConverter.convertToDTO(pedidoProducto);
    }

    @PutMapping(path="{id}")
    public PedidoProductoDTO actualizar(
        @PathVariable("id") Long idPedido,
        @RequestParam(required = false) Integer cantidad,
        @RequestParam(required = false) Double precioUnitario
    ) {
        PedidoProducto pedidoProducto = ppService.updatePedido(idPedido, cantidad, precioUnitario);
        return DTOConverter.convertToDTO(pedidoProducto);
    }
}
