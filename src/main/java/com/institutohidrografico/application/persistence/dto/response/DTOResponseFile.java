package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseFile {

    private String fileName;
    private String fileType;
    private long size;

    public static DTOResponseFile toDTO(File file) {
        return new DTOResponseFile(file.getFileName(), file.getFileType(), file.getSize());
    }
}