package com.company.project.resolver;

import com.company.project.model.Notes;
import com.company.project.service.NotesService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HelloWood
 */
@Component
public class NotesQuery implements GraphQLQueryResolver {

    @Autowired
    private NotesService notesService;
    
    public NotesQuery(){}


    public List<Notes> notes() {
        return notesService.findAll();
    }

    public Notes notes(String id) {
        return notesService.findById(id);
    }

}
