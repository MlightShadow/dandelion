package com.company.project.service;

import com.company.project.model.Notes;
import com.company.project.dto.NotesDTO;
import com.company.project.core.Service;

/**
 * Created by CodeGenerator on 2019/06/26.
 */
public interface NotesService extends Service<Notes> {
    Notes addNotes(NotesDTO dto);

    int updateNotes(String id, NotesDTO dto);
    
    int deleteNotes(String id);
}
