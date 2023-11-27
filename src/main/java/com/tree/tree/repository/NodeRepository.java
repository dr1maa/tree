package com.tree.tree.repository;

import com.tree.tree.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {

    Node findById(int id);

    Node save(Node node);

    Node saveAndFlush(Node node);

    void deleteById(int id);

    List<Node> findByParentId(int parentId);

    List<Node> findByParentIsNull();
}
