package com.tree.tree.servise;

import com.tree.tree.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NodeService {
    List<Node> getAllNodes();

    Node addNode(Node node);

    Node getNodeById(int nodeId);

    Node updateNode(Node updatedNode);

    void deleteNode(int nodeId);

    List<Node> getChildren(int parentId);

    List<Node> getRootNodes();

}
