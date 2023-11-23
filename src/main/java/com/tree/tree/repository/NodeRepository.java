package com.tree.tree.repository;

import com.tree.tree.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {

    Node findById(int id);

    List<Node> findByParent(Node parent);

    List<Node> findByParentIsNull();

    Node save(Node node);

    Node saveAndFlush(Node node);

    void deleteById(int id);

    void deleteByParent(Node parent);
}
