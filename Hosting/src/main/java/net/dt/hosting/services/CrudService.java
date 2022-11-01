package net.dt.hosting.services;
import java.util.List;

public interface CrudService<RequestDTO, ResponseDTO> {
    ResponseDTO getOne(String id);
    List<ResponseDTO> getAll();
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    void delete(String id);
}

