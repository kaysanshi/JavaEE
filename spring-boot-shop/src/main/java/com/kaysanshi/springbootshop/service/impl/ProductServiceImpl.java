package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.CategoryMapper;
import com.kaysanshi.springbootshop.dao.ProductMapper;
import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.ProductDTO;
import com.kaysanshi.springbootshop.dto.ProductQueryDTO;
import com.kaysanshi.springbootshop.dto.ProductQueryVO;
import com.kaysanshi.springbootshop.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Product add(Product product) {
        if (productMapper.insert(product) > 0) {
            return productMapper.selectByPrimaryKey(product);
        } else {
            return null;
        }

    }

    @Override
    public Product update(Product product) {
        if (productMapper.updateByPrimaryKey(product) > 0) {
            return productMapper.selectByPrimaryKey(product);
        } else {
            return null;
        }
    }

    @Override
    public Integer delete(Product product) {
        if (productMapper.delete(product) > 0) {
            return productMapper.delete(product);
        } else {
            return null;
        }
    }

    @Override
    public ProductDTO <Product> getList(Integer page, Integer size, String search, String publicStatus, String newStatus, String sort, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");

            search = Arrays
                    .stream(tags)
                    /*filter方法 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。*/
                    .filter(StringUtils::isNotBlank)
                    /*map方法 如果有值，则对其执行调用mapper函数得到返回值。*/
                    //返回值并且依然Optional包裹起来,其泛型和你返回值的类型一致
                    .map(t -> t.replace("+", "").replace("*", "").replace("?", ""))
                    .filter(StringUtils::isNotBlank) //:: 引用这个构造函数
                    .collect(Collectors.joining("|"));
        }
        //封装返回的数据
        ProductDTO productDTO = new ProductDTO();
        // 封装查询数据
        ProductQueryDTO productQueryDTO = new ProductQueryDTO();
        productQueryDTO.setNewStatus(newStatus);
        productQueryDTO.setPublicStatus(publicStatus);
        productQueryDTO.setSearch(search);
        Integer totalPage;
        Integer totalCount = productMapper.countBySearch(productQueryDTO);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        productDTO.setPagination(totalPage, page);
        Integer offset = page < 1 ? 0 : size * (page - 1);
        productQueryDTO.setSize(size);
        productQueryDTO.setPage(offset);
        List <Product> productList = productMapper.getProductListBySearch(productQueryDTO);
//        List<ProductDTO> productDTOList= new ArrayList <>();
        for (Product product : productList) {
            Category category = new Category();
            category.setId(product.getCid());
            Category category_temp = categoryMapper.selectOne(category);
            product.setCategory(category_temp);
        }
        productDTO.setData(productList);
        return productDTO;
    }

    @Override
    public Product getProduct(Product product) {
        Product productTemp = productMapper.selectOne(product);
        if (productTemp != null) {
            Category category_temp = new Category();
            category_temp.setId(productTemp.getCid());
            Category category = categoryMapper.selectOne(category_temp);
            productTemp.setCategory(category);
            return productTemp;
        } else {
            return null;
        }
    }

    @Override
    public BaseResult getlist(ProductQueryVO productQueryVO) {
        Map<String, Object> res = new HashMap<>();
        productQueryVO.setStart((productQueryVO.getPage() - 1) * productQueryVO.getLimit());
        List<Product> list = productMapper.query(productQueryVO);
        if (list !=null){
            for (Product product : list) {
                Category category = new Category();
                category.setId(product.getCid());
                Category category_temp = categoryMapper.selectOne(category);
                product.setCategory(category_temp);
            }
        }
        int sum = productMapper.querySum(productQueryVO);
        res.put("code","0");
        res.put("data", list);
        res.put("count", sum);
        //System.out.println(res);
        return BaseResult.createResult(res.get("code").toString(),"操作成功",res.get("data"),res.get("count").toString());


    }
}
