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
    public Node addNode(Node node,int parentId) {
       Node parentNode = nodeRepository.findById(parentId);
        if (parentNode != null) {
            node.setParent(parentNode);
            parentNode.getChildren().add(node);
            nodeRepository.save(parentNode);
            return nodeRepository.save(node);
        } else {
            return null;
        }
    }

    @Override
    public Node getNode(int nodeId) {
     return nodeRepository.findById(nodeId);
    }

    @Override
    public Node updateNode(int nodeId, Node updatedNode) {
        Node existingNode = nodeRepository.findById(nodeId);
        if (existingNode != null) {
                existingNode.setName(updatedNode.getName());
                existingNode.setIp(updatedNode.getIp());
                existingNode.setPort(updatedNode.getPort());
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

    @Override
    public Node addNode(Node node) {
        return nodeRepository.save(node);
    }
}
