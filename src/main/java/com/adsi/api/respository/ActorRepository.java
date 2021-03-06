
package com.adsi.api.respository;

import com.adsi.api.modelo.Actor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ActorRepository extends JpaRepository<Actor, Short>{
    
    
    @Query(value = "SELECT * FROM actor where first_name = :nombre",nativeQuery = true)
    List<Actor> listarPorNombre(@Param("nombre") String nombre );
    
    @Query(value = "SELECT * FROM actor where first_name like :parametro OR last_name like :parametro ", nativeQuery = true)
    List<Actor> consultarConLike(@Param("parametro") String parametro );


    @Query(value = "SELECT * FROM actor where actor_id = :id_actor", nativeQuery = true)
    List<Actor> listarActor(@Param("id_actor") short id_actor);
    
    
}
