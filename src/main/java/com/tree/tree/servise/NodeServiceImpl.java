package com.tree.tree.servise;

import com.tree.tree.model.Node;
import com.tree.tree.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private final NodeRepository nodeRepository;
    private List<Node> nodes = new ArrayList<>();

    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }


    @Override
    public Node addNode(Node node) {
        Node savedNode = nodeRepository.save(node);
        nodes.add(savedNode);
        return savedNode;
    }

    @Override
    public Node getNode(int nodeId) {
        if (nodeRepository.findById(nodeId) == null) {
            return null;
        } else {
            return nodeRepository.findById(nodeId);
        }
    }

    @Override
    public Node updateNode(int nodeId, Node updatedNode) {
        Node existingNode = nodeRepository.findById(nodeId);
        if (existingNode != null) {
            existingNode.setParent(updatedNode.getParent());
            existingNode.setChildren(updatedNode.getChildren());
            existingNode.setName(updatedNode.getName());
            existingNode.setPort(updatedNode.getPort());
            existingNode.setIp(updatedNode.getIp());
            return nodeRepository.save(existingNode);
        }
        return null;
    }

    @Override
    public void deleteNode(int nodeId) {
        nodeRepository.deleteById(nodeId);
    }

    @Override
    public List<Node> getChildren(int parentId) {
        return nodeRepository.findByParentId(parentId);
    }

    @Override
    public List<Node> getRootNodes() {

       return nodeRepository.findByParentIsNull();
    }
}
