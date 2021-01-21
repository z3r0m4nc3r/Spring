package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;

public interface PedidosJpaRepository extends JpaRepository<Pedido, Integer> {

}
