package com.tree.tree.servise;

import com.tree.tree.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NodeService {
    List<Node> getAllNodes();

    Node addNode(Node node, Integer parentId);

    Node getNode(int nodeId);

    Node updateNode(Integer id,Node updatedNode);

    void deleteNode(Integer id);

    List<Node> getChildren(Integer parentId);

    List<Node> getRootNodes();
}
