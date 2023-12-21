package com.nocountry.S12G15.persistance.repository;


import com.nocountry.S12G15.domain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface CommentRepository extends JpaRepository<CommentEntity, String> {

    @Query(value = "SELECT * FROM comment_entity WHERE id_channel = :id ORDER BY local_date_time", nativeQuery = true)
    List<CommentEntity> findAllComments(@Param("id") String idChannel);



    //@Query(value = "SELECT c FROM CommentEntity c WHERE c.channelEntity.id_Channel = :id")
    //List<CommentEntity> findByChannel(@Param("id") String idChannel);

    //@Query(value = "SELECT * FROM CommentEntity")
    //String encontra();

    // @Query(value = "SELECT * FROM CommentEntity where name = ?1 AND email = ?2", nativeQuery = true)
    //List<User> getUserByNameAndEmail(String name, String email);

}
