package com.Kcas.Library.services;

import com.Kcas.Library.entities.Groups;
import com.Kcas.Library.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {
    private final GroupsRepository groupsRepository;

    @Autowired
    public GroupsService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public List<Groups> getAllGroups() {
        return groupsRepository.findAll();
    }

    public Optional<Groups> getGroupById(Long id) {
        return groupsRepository.findById(id);
    }

    public Groups saveGroup(Groups group) {
        return groupsRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupsRepository.deleteById(id);
    }
}
