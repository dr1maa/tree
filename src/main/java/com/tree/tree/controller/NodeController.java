package com.tree.tree.controller;


import com.tree.tree.model.Node;
import com.tree.tree.servise.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/nodes/")
public class NodeController {

    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping
    public List<Node> getAllNodes() {
        return nodeService.getAllNodes();
    }

    @PostMapping
    public Node addNode(@RequestBody Node node) {
        return nodeService.addNode(node);
    }

    @GetMapping("/{nodeId}")
    public Node getNode(@PathVariable int nodeId) {
        return nodeService.getNode(nodeId);
    }

    @DeleteMapping("/{nodeId}")
    public void deleteNode(@PathVariable int nodeId) {
        nodeService.deleteNode(nodeId);
    }

    @GetMapping("/{nodeId}/children")
    public List<Node> getChildren(@PathVariable int nodeId) {
        return nodeService.getChildren(nodeId);
    }

    @GetMapping("/root")
    public List<Node> getRootNodes() {
        return nodeService.getRootNodes();
    }
}
