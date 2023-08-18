package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.Groups;
import com.Kcas.Library.services.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {
    private final GroupsService groupsService;

    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping
    public List<Groups> getAllGroups() {
        return groupsService.getAllGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groups> getGroupById(@PathVariable Long id) {
        Optional<Groups> group = groupsService.getGroupById(id);
        return group.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Groups> createGroup(@RequestBody Groups group) {
        Groups savedGroup = groupsService.saveGroup(group);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Groups> updateGroup(@PathVariable Long id, @RequestBody Groups group) {
        if (groupsService.getGroupById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        group.setId(id);
        Groups updatedGroup = groupsService.saveGroup(group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        if (groupsService.getGroupById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        groupsService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
