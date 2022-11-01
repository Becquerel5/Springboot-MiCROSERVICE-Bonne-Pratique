package net.dt.customer.services;

import java.util.List;

public interface Generalcrud <RequestDTO,ResponseDTO> {
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO get(String id);
    ResponseDTO update(RequestDTO requestDTO);
    List<ResponseDTO> list();
    void delete(String id);
}
