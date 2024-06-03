//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/Categoria/CategoriaService.java
package com.jorgecolors.jorgecolors.Categoria;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepo;

    public void guardarCategoria(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    public List<Categoria> obtenerTodasCategorias() {
        return categoriaRepo.findAll();
    }
}
