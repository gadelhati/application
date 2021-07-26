package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTORequestFile {

    private String fileName;
    private String fileType;
    private long size;

    public File toObject(){
        return new File(fileName, fileType, size);
    }
}