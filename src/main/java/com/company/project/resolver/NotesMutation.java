package com.company.project.resolver;

import java.util.Date;

import com.company.project.dto.NotesDTO;
import com.company.project.model.Notes;
import com.company.project.service.NotesService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Post modify resolver
 *
 * @author HelloWood
 */
@Component
public class NotesMutation implements GraphQLMutationResolver {

    @Autowired
    private NotesService notesService;

    public NotesMutation(){}

    /**
     * Create Post
     *
     * @param post The create Post entity
     * @return The created Post entity
     */
    public Notes createPost(NotesDTO dto) {
        Notes notes = new Notes();
        notes.setId("213231");
        notes.setIsDeleted(false);
        notes.setCreateTime(new Date());
        notes.setCreator("12312312");
        notes.setTitle(dto.getTitle());
        notes.setContent(dto.getContent());
        notesService.save(notes);

        return notes;
    }
}
