package io.cygnuxltb.console.service;

import io.cygnuxltb.console.persistence.entity.TblSProduct;
import io.cygnuxltb.console.persistence.dao.ProductDao;
import io.cygnuxltb.console.service.util.DtoConverter;
import io.cygnuxltb.protocol.http.response.ProductDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static io.cygnuxltb.console.persistence.util.DaoExecutor.select;

@Component
public final class ProductService {

    @Resource
    private ProductDao dao;

    public List<ProductDTO> get() {
        return select(TblSProduct.class, () -> dao.findAll())
                .stream()
                .map(DtoConverter::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO get(int productId) {
        return DtoConverter.toDTO(dao.queryByProductId(productId));
    }

}
