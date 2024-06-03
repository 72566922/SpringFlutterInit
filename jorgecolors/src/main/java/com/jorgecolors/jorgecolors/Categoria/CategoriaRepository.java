//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/Categoria/CategoriaRepository.java
package com.jorgecolors.jorgecolors.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



// Debes añadir la anotación @Repository para indicar que es un componente de repositorio gestionado por Spring
@Repository
// Debes extender JpaRepository con los tipos de datos correctos (Categoria y Integer)
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
