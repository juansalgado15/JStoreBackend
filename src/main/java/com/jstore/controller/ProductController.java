package com.jstore.controller;

import com.jstore.dto.request.ProductRequestDTO;
import com.jstore.dto.response.ProductResponseDTO;
import com.jstore.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
@Tag(
        name = "Productos",
        description = "Operaciones CRUD para la gestión de productos"
)
public class ProductController {


    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * Obtiene todos los productos registrados.
     */
    @Operation(
            summary = "Listar productos",
            description = "Obtiene la lista completa de productos registrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Productos encontrados"
    )
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        return ResponseEntity.ok(
                productService.findAll()
        );
    }


    /**
     * Obtiene un producto por ID.
     */
    @Operation(
            summary = "Buscar producto por ID",
            description = "Consulta un producto específico mediante su identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Producto encontrado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @Parameter(
                    description = "Identificador del producto"
            )
            @PathVariable Long id) {


        return ResponseEntity.ok(
                productService.findById(id)
        );
    }


    /**
     * Crea un producto.
     */
    @Operation(
            summary = "Crear producto",
            description = "Registra un nuevo producto en el sistema"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Producto creado correctamente"
    )
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @Valid @RequestBody ProductRequestDTO request) {


        ProductResponseDTO response =
                productService.save(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    /**
     * Actualiza un producto.
     */
    @Operation(
            summary = "Actualizar producto",
            description = "Modifica la información de un producto existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Producto actualizado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {


        ProductResponseDTO response =
                productService.update(id, request);


        return ResponseEntity.ok(response);
    }


    /**
     * Elimina un producto.
     */
    @Operation(
            summary = "Eliminar producto",
            description = "Elimina un producto mediante su identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Producto eliminado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {


        productService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}