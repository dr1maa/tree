package com.tree.tree.servise;

import com.tree.tree.model.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {
    private List<Node> nodes = new ArrayList<>();

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }


    @Override
    public Node addNode(Node node) {
        nodes.add(node);
        return node;
    }

    @Override
    public Node getNode(int nodeId) {
        return nodes.stream()
                .filter(node -> node.getId() == nodeId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Node updateNode(int nodeId,Node updatedNode) {
        for (int i = 0; i< nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node.getId() == nodeId) {
                node.setParent(updatedNode.getParent());
                node.setChildren(updatedNode.getChildren());
                node.setName(updatedNode.getName());
                node.setPort(updatedNode.getPort());
                node.setIp(updatedNode.getIp());
                return node;
            }
        }
        return null;
    }

    @Override
    public void deleteNode(int nodeId) {
        nodes.removeIf(node -> node.getId() == nodeId);
    }

    @Override
    public List<Node> getChildren(int parentId) {
        List<Node> children = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getParent() != null && node.getParent().getId() == parentId) {
                children.add(node);
            }
        }
        return children;
    }

    @Override
    public List<Node> getRootNodes() {
        List<Node> rootNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getParent() == null) {
                rootNodes.add(node);
            }
        }
        return rootNodes;
    }
}
