package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.repository.crud.CategoriaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository CategoriaCrudRepository;

    public List<Categoria> getAll() {
        return (List<Categoria>) CategoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getCabana(int id) {
        return CategoriaCrudRepository.findById(id);
    }

    public Categoria save(Categoria Categoria) {
        return CategoriaCrudRepository.save(Categoria);
    }

    public void delete(Categoria Categoria) {
        CategoriaCrudRepository.delete(Categoria);
    }
}
