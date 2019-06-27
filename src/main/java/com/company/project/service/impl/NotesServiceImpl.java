package com.company.project.service.impl;

import com.company.project.dao.NotesMapper;
import com.company.project.dto.NotesDTO;
import com.company.project.model.Notes;
import com.company.project.service.NotesService;
import com.company.project.util.SecurityContextUtil;
import com.company.project.util.UUIDUtil;
import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2019/06/26.
 */
@Service
@Transactional
public class NotesServiceImpl extends AbstractService<Notes> implements NotesService {
    @Resource
    private NotesMapper notesMapper;

    @Autowired
    private SecurityContextUtil securityContextUtil;

    @Autowired
    private UUIDUtil uuid;

    @Override
    public Notes addNotes(NotesDTO dto) {
        Notes notes = new Notes();
        notes.setId(uuid.getUUID());
        notes.setIsDeleted(false);
        notes.setCreateTime(new Date());
        notes.setCreator(securityContextUtil.getAuthInfo().getId());

        int rows = this.save(notes);
        if (rows == 1) {
            return notes;
        } else {
            throw new ServiceException("notes添加失败");
        }
    }

    @Override
    public int updateNotes(String id, NotesDTO dto) {
        Notes notes = new Notes();
        notes.setId(id);

        int rows = this.update(notes);
        if (rows == 1) {
            return rows;
        } else {
            throw new ServiceException("notes更新失败");
        }
    }

    @Override
    public int deleteNotes(String id) {
        Notes notes = new Notes();
        notes.setId(id);
        notes.setIsDeleted(true);
        int rows = this.update(notes);
        if (rows == 1) {
            return rows;
        } else {
            throw new ServiceException("notes删除失败");
        }
    }
}
