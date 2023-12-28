package producto.producto.domain;

import lombok.Data;

@Data
public class ProductoDTO {

    private String nombre;
    private int precio;
    private int stock;
}
