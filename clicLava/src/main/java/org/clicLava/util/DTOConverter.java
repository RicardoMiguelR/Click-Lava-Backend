package org.clicLava.util;

import org.clicLava.dto.*;
import org.clicLava.model.*;
import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter {
    
    // Conversiones de Rol
    public static RolDTO convertToDTO(Rol rol) {
        if (rol == null) return null;
        return new RolDTO(rol.getId(), rol.getRol());
    }
    
    // Conversiones de Usuario
    public static UsuarioDTO convertToDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getApellidos(),
            usuario.getEmail(),
            usuario.getTelefono(),
            usuario.getFechaRegistro(),
            convertToDTO(usuario.getRol())
        );
    }
    
    // Conversiones de Producto
    public static ProductoDTO convertToDTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getImagen()
        );
    }
    
    // Conversiones de PedidoProducto
    public static PedidoProductoDTO convertToDTO(PedidoProducto pedidoProducto) {
        if (pedidoProducto == null) return null;
        return new PedidoProductoDTO(
            pedidoProducto.getIdPedidoProducto(),
            pedidoProducto.getPedido().getId(),
            pedidoProducto.getProducto().getId(),
            pedidoProducto.getProducto().getNombre(),
            pedidoProducto.getCantidad(),
            pedidoProducto.getPrecioUnitario()
        );
    }
    
    // Conversiones de Pedido
    public static PedidoDTO convertToDTO(Pedido pedido) {
        if (pedido == null) return null;
        PedidoDTO pedidoDTO = new PedidoDTO(
            pedido.getId(),
            pedido.getCalle(),
            pedido.getColonia(),
            pedido.getMunicipio(),
            pedido.getCodigoPostal(),
            pedido.getFechaPedido(),
            pedido.getCantidad(),
            calcularTotalPedido(pedido), // Calcular el total basado en los productos
            pedido.getUsuario().getId(),
            pedido.getUsuario().getNombre()
        );
        
        if (pedido.getPedidoProductos() != null) {
            List<PedidoProductoDTO> pedidoProductosDTO = pedido.getPedidoProductos().stream()
                .map(DTOConverter::convertToDTO)
                .collect(Collectors.toList());
            pedidoDTO.setPedidoProductos(pedidoProductosDTO);
        }
        
        return pedidoDTO;
    }
    
    // Conversiones de Tarjeta
    public static TarjetaDTO convertToDTO(Tarjeta tarjeta) {
        if (tarjeta == null) return null;
        return new TarjetaDTO(
            tarjeta.getId(),
            tarjeta.getNombreTitular(),
            tarjeta.getNumeroTarjeta(),
            tarjeta.getVencimiento(),
            tarjeta.getCvv(),
            tarjeta.getUsuario().getId(),
            tarjeta.getUsuario().getNombre()
        );
    }
    
    // Conversiones de Pago
    public static PagoDTO convertToDTO(Pago pago) {
        if (pago == null) return null;
        return new PagoDTO(
            pago.getId(),
            pago.getMonto(),
            pago.getFechaPago(),
            pago.getTarjeta().getId(),
            pago.getPedido().getId()
        );
    }
    
    // Métodos para convertir listas
    public static List<UsuarioDTO> convertToUsuarioDTOList(List<Usuario> usuarios) {
        return usuarios.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public static List<RolDTO> convertToRolDTOList(List<Rol> roles) {
        return roles.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public static List<ProductoDTO> convertToProductoDTOList(List<Producto> productos) {
        return productos.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public static List<PedidoDTO> convertToPedidoDTOList(List<Pedido> pedidos) {
        return pedidos.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public static List<TarjetaDTO> convertToTarjetaDTOList(List<Tarjeta> tarjetas) {
        return tarjetas.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public static List<PagoDTO> convertToPagoDTOList(List<Pago> pagos) {
        return pagos.stream()
            .map(DTOConverter::convertToDTO)
            .collect(Collectors.toList());
    }



    // Método auxiliar para calcular el total del pedido
    private static Double calcularTotalPedido(Pedido pedido) {
        if (pedido.getPedidoProductos() == null || pedido.getPedidoProductos().isEmpty()) {
            return 0.0; // Valor por defecto si no hay productos
        }
        
        return pedido.getPedidoProductos().stream()
            .mapToDouble(pp -> pp.getCantidad() * pp.getPrecioUnitario())
            .sum();
    }
    
}