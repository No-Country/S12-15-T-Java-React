package com.nocountry.S12G15.persistance.repository;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.CommentEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity,String> {


//    @Query(value = "SELECT c FROM ChannelEntity c WHERE c.idChannel = :id AND c.BoardEntity.idBoard= :id_board")
//    ChannelEntity findOneByIdBoard(@Param("id") String id, @Param("id_board") String id_board);
//
//    @Query(value = "SELECT c FROM ChannelEntity  c WHERE c.BoardEntity.idBoard= :id_board",
//            countQuery = "SELECT COUNT(c) FROM ChannelEntity  c WHERE c.BoardEntity.idBoard= :id_board")
//    Page<ChannelEntity> findAllByIdBoard(@Param("id_board") String id_board, Pageable pageable);


}
