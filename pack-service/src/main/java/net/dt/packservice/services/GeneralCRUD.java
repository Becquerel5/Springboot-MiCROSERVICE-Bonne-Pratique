package net.dt.packservice.services;

import java.util.List;

public interface GeneralCRUD<RequestDTO,ResponseDTO> {
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO get(String id);
    ResponseDTO update(RequestDTO requestDTO);
    List<ResponseDTO> list();
    void delete(String id);
}
