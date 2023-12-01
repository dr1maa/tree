package com.tree.tree.servise;

import com.tree.tree.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NodeService {
    List<Node> getAllNodes();

    Node addNode(Node node, int parentId);

    Node getNode(int nodeId);

    Node updateNode(Integer nodeId,Node updatedNode);

    void deleteNode(Integer nodeId);

    List<Node> getChildren(int parentId);

    List<Node> getRootNodes();
}
