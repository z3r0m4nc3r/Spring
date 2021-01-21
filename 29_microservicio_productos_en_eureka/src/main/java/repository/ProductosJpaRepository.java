package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Producto;

public interface ProductosJpaRepository extends JpaRepository<Producto, Integer> {

}
