package com.tree.tree.servise;

import com.tree.tree.model.Node;
import com.tree.tree.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private final NodeRepository nodeRepository;

    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }


    @Override
    public Node addNode(Node node, Integer parentId) {
        Optional<Node> optionalParentNode = nodeRepository.findById(parentId);
        if (optionalParentNode.isPresent()) {
            Node parentNode = optionalParentNode.get();
            parentNode.getChildren().add(node);
            nodeRepository.save(parentNode);
        }

        return nodeRepository.save(node);
    }


    @Override
    public Node getNode(int nodeId) {
        return nodeRepository.findById(nodeId);
    }

    @Override
    public Node updateNode(Integer nodeId, Node updatedNode) {
        Optional<Node> existingNodeOptional = nodeRepository.findById(nodeId);
        if (existingNodeOptional != null) {
            Node existingNode = existingNodeOptional.get();
            existingNode.setName(updatedNode.getName());
            existingNode.setIp(updatedNode.getIp());
            existingNode.setPort(updatedNode.getPort());
            return nodeRepository.save(existingNode);
        }
        return null;
    }

    @Override
    public void deleteNode(Integer nodeId) {
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
