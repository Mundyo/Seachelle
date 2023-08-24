package seachelle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import seachelle.entity.Seachelle;

public interface SeachelleDao extends JpaRepository<Seachelle, Long> {

}
